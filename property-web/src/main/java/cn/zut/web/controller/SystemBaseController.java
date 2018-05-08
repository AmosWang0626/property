package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.facade.api.ComboVO;
import cn.zut.facade.enums.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/18
 */
@RestController
@RequestMapping("base")
public class SystemBaseController {

    @GetMapping("getPaymentStatus")
    public GenericResponse getPaymentStatus() {
        List<ComboVO> comboVOList = new ArrayList<>();
        for (PaymentStatusEnum paymentStatusEnum : PaymentStatusEnum.values()) {
            comboVOList.add(new ComboVO<>(paymentStatusEnum));
        }

        return new GenericResponse<>(comboVOList);
    }

    @GetMapping("getPaymentWay")
    public GenericResponse getPaymentWay() {
        List<ComboVO> comboVOList = new ArrayList<>();
        for (PaymentWayEnum paymentWayEnum : PaymentWayEnum.values()) {
            comboVOList.add(new ComboVO<>(paymentWayEnum));
        }

        return new GenericResponse<>(comboVOList);
    }

    @GetMapping("getBusiness")
    public GenericResponse getBusiness() {
        List<ComboVO> comboVOList = new ArrayList<>();
        for (BusinessTypeEnum businessTypeEnum : BusinessTypeEnum.values()) {
            comboVOList.add(new ComboVO<>(businessTypeEnum));
        }

        return new GenericResponse<>(comboVOList);
    }

    @GetMapping("getImmediateBusiness")
    public GenericResponse getImmediateBusiness() {
        List<ComboVO> comboVOList = new ArrayList<>();
        comboVOList.add(new ComboVO<>(BusinessTypeEnum.SITE));
        comboVOList.add(new ComboVO<>(BusinessTypeEnum.PARKING));

        return new GenericResponse<>(comboVOList);
    }

    @GetMapping("getBillEntryBusiness")
    public GenericResponse getBillEntryBusiness() {
        List<ComboVO> comboVOList = new ArrayList<>();
        comboVOList.add(new ComboVO<>(BusinessTypeEnum.WATER));
        comboVOList.add(new ComboVO<>(BusinessTypeEnum.ELECTRICITY));
        comboVOList.add(new ComboVO<>(BusinessTypeEnum.NETWORK));
        comboVOList.add(new ComboVO<>(BusinessTypeEnum.PROPERTY));

        return new GenericResponse<>(comboVOList);
    }

    @GetMapping("getBusinessLevel")
    public GenericResponse getBusinessLevel(@RequestParam(value = "business", required = false) BusinessTypeEnum business) {
        if (business == null) {
            return GenericResponse.SUCCESS;
        }

        List<ComboVO> comboVOList = null;

        switch (business) {
            case WATER:
                comboVOList = BusinessLevelEnum.getWaterList();
                break;
            case ELECTRICITY:
                comboVOList = BusinessLevelEnum.getElectricityList();
                break;
            case PROPERTY:
                comboVOList = BusinessLevelEnum.getPropertyList();
                break;
            case SITE:
                comboVOList = BusinessLevelEnum.getSiteList();
                break;
            case NETWORK:
                comboVOList = BusinessLevelEnum.getNetworkList();
                break;
            case PARKING:
                comboVOList = BusinessLevelEnum.getParkingList();
                break;
            default:
                break;
        }

        return new GenericResponse<>(comboVOList);
    }

    @GetMapping("getServiceType")
    public GenericResponse getServiceType() {
        List<ComboVO> comboVOList = new ArrayList<>();
        for (ServiceTypeEnum singleEnum : ServiceTypeEnum.values()) {
            comboVOList.add(new ComboVO<>(singleEnum));
        }

        return new GenericResponse<>(comboVOList);
    }
}
