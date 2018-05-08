package cn.zut.core.service.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.service.BusinessService;
import cn.zut.dao.entity.BusinessServiceEntity;
import cn.zut.dao.persistence.BusinessServiceMapper;
import cn.zut.facade.enums.ServiceSatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private BusinessServiceMapper businessServiceMapper;

    /**
     * 添加服务申请
     */
    @Override
    public GenericResponse addService(BusinessServiceEntity businessServiceEntity) {
        businessServiceEntity.setCreateTime(new Date());
        businessServiceEntity.setStatus(ServiceSatus.IN_APPLY.toString());

        boolean addStatus = businessServiceMapper.insert(businessServiceEntity) > 0;
        // 插入成功,返回GenericResponse.SUCCESS
        if (addStatus) {
            return GenericResponse.SUCCESS;
        }
        return new GenericResponse(new ExceptionMessage(ExceptionCode.BUSINESS_SERVICE_ADD_FAIL));
    }

    /**
     * 服务列表
     */
    @Override
    public SimplePageResult<BusinessServiceEntity> serviceList(PageModel<BusinessServiceEntity> pageModel) {
        List<BusinessServiceEntity> tariffCompanyEntities = businessServiceMapper.selectListPageByExample(pageModel);
        int memberCount = businessServiceMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<BusinessServiceEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(memberCount);
        pageResult.setRows(tariffCompanyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());

        return pageResult;
    }

    /**
     * 同意服务申请
     */
    @Override
    public boolean agreeService(int serviceId) {
        BusinessServiceEntity businessServiceEntity = businessServiceMapper.selectById(serviceId);
        if (businessServiceEntity == null) {
            return false;
        }
        businessServiceEntity.setStatus(ServiceSatus.IN_DEAL.getKey());
        int x = businessServiceMapper.update(businessServiceEntity);

        return x > 0;
    }

    /**
     * 不同意服务操作
     */
    @Override
    public boolean disAgreeService(int serviceId) {
        BusinessServiceEntity businessServiceEntity = businessServiceMapper.selectById(serviceId);
        if (businessServiceEntity == null) {
            return false;
        }
        businessServiceEntity.setStatus(ServiceSatus.NO_CONSENT.getKey());
        int x = businessServiceMapper.update(businessServiceEntity);

        return x > 0;
    }
}
