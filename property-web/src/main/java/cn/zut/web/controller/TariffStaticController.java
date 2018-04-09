package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.TariffStaticBusiness;
import cn.zut.facade.request.TariffCompanyRequest;
import cn.zut.facade.request.TariffStandardRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
