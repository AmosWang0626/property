package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.TariffStaticBusiness;
import cn.zut.dao.entity.TariffCompanyEntity;
import cn.zut.dao.entity.TariffStandardEntity;
import cn.zut.facade.request.TariffCompanyRequest;
import cn.zut.facade.request.TariffStandardRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/8
 */
@RestController
@RequestMapping("static")
public class TariffStaticController {

    @Resource
    private TariffStaticBusiness tariffStaticBusiness;

    @RequestMapping(value = "addCompany", method = RequestMethod.POST)
    public GenericResponse addCompany(@RequestBody TariffCompanyRequest tariffCompanyRequest) {
        StringBuilder sb = new StringBuilder();
        for (String msg : tariffCompanyRequest.getCity()) {
            sb.append(msg);
        }
        tariffCompanyRequest.setAddress(sb.append(tariffCompanyRequest.getAddress()).toString());

        return tariffStaticBusiness.addCompany(tariffCompanyRequest);
    }

    @RequestMapping(value = "addStandard", method = RequestMethod.POST)
    public GenericResponse addStandard(@RequestBody TariffStandardRequest tariffStandardRequest) {
        return tariffStaticBusiness.addStandard(tariffStandardRequest);
    }

    @RequestMapping(value = "modifyCompany", method = RequestMethod.POST)
    public GenericResponse modifyCompany(@RequestBody TariffCompanyRequest tariffCompanyRequest) {
        return tariffStaticBusiness.modifyCompany(tariffCompanyRequest);
    }

    @RequestMapping(value = "modifyStandard", method = RequestMethod.POST)
    public GenericResponse modifyStandard(@RequestBody TariffStandardRequest tariffStandardRequest) {
        return tariffStaticBusiness.modifyStandard(tariffStandardRequest);
    }

    @RequestMapping(value = "deleteCompany", method = RequestMethod.POST)
    public GenericResponse deleteCompany(@RequestBody TariffCompanyRequest tariffCompanyRequest) {
        return tariffStaticBusiness.removeCompany(tariffCompanyRequest.getCompanyId());
    }

    @RequestMapping(value = "deleteStandard", method = RequestMethod.POST)
    public GenericResponse deleteStandard(@RequestBody TariffStandardRequest tariffStandardRequest) {
        return tariffStaticBusiness.removeStandard(tariffStandardRequest.getStandardId());
    }

    @GetMapping("pageCompany")
    public GenericResponse pageCompany(@RequestParam(value = "page", required = false) Integer page,
                                       @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<TariffCompanyEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(tariffStaticBusiness.pageCompanyByModel(pageModel));
    }

    @GetMapping("pageStandard")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<TariffStandardEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(tariffStaticBusiness.pageStandardByModel(pageModel));
    }

}
