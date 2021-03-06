package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.CarBusiness;
import cn.zut.core.service.BusinessCarSetService;
import cn.zut.dao.entity.BusinessCarSetEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
@RestController
@RequestMapping("car")
public class BusinessCarController {

    @Resource
    private BusinessCarSetService businessCarSetService;

    @Resource
    private CarBusiness carBusiness;

    /**
     * 主要三个参数
     * 车牌号/车类型/进入时间
     */
    @RequestMapping("comeIn")
    @ResponseBody
    public GenericResponse comeIn(@RequestBody BusinessCarSetEntity businessCarSetEntity) {

        return businessCarSetService.addCarSet(businessCarSetEntity) ? GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> carList() {
        List<BusinessCarSetEntity> list = businessCarSetService.carList();
        Map<String, Object> resuletMap = new HashMap<>();
        resuletMap.put("data", list);
        resuletMap.put("msg", "");
        resuletMap.put("code", "0");
        return resuletMap;
    }

    @RequestMapping("detail")
    public String carSearch(int id, HttpServletRequest request) {
        BusinessCarSetEntity businessCarSetEntity = businessCarSetService.searchCarSet(id);
        request.setAttribute("businessCarSetEntity", businessCarSetEntity);
        return "carsetdetail";
    }

    @RequestMapping("getRent")
    public String getRent(int id, HttpServletRequest request) {
        BusinessCarSetEntity businessCarSetEntity = businessCarSetService.searchCarSet(id);
        request.setAttribute("businessCarSetEntity", businessCarSetEntity);
        return "getrent";
    }

    @RequestMapping("rentCar")
    public GenericResponse rentCar(@RequestBody BusinessCarSetEntity businessCarSetEntity) {
        boolean flag = businessCarSetService.rentCar(businessCarSetEntity);
        return flag ? GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    @GetMapping("pagecar")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<BusinessCarSetEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(carBusiness.pageMemberByModel(pageModel));

    }
}