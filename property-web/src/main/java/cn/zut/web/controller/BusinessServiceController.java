package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.BusinessService;
import cn.zut.dao.entity.BusinessServiceEntity;
import cn.zut.facade.enums.ServiceSatus;
import cn.zut.facade.enums.ServiceTypeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LiuBowen
 */
@RestController
@RequestMapping("service")
public class BusinessServiceController {

    @Resource
    private BusinessService businessService;

    /**
     * 添加服务
     *
     * @param businessServiceEntity BusinessServiceEntity
     * @param request       HttpServletRequest
     */
    @RequestMapping("add")
    public GenericResponse serviceAdd(BusinessServiceEntity businessServiceEntity, HttpServletRequest request) {
        businessServiceEntity.setMemberId(getMemberId(request));

        return businessService.addService(businessServiceEntity);
    }


    @GetMapping("list")
    public GenericResponse serviceList(@RequestParam(value = "page", required = false) Integer page,
                                       @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<BusinessServiceEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        List<BusinessServiceEntity> serviceEntities = businessService.serviceList();

        serviceEntities.forEach(businessServiceEntity -> {
            businessServiceEntity.setType(ServiceTypeEnum.valueOf(businessServiceEntity.getType()).getValue());
            businessServiceEntity.setStatus(ServiceSatus.valueOf(businessServiceEntity.getStatus()).getValue());
        });

        return new GenericResponse<>(serviceEntities);
    }

    @RequestMapping("agree")
    public boolean agreeService(int serviceId) {
        return businessService.agreeService(serviceId);
    }

    @RequestMapping("disagree")
    public boolean disAgreeService(int serviceId) {
        return businessService.disAgreeService(serviceId);
    }

    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }

}
