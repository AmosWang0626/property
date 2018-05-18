package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.PropertyJobBusiness;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PROJECT: property
 * DESCRIPTION: 系统管理员管理页面
 *
 * @author DaoYuanWang
 * @date 2018/4/25
 */
@RestController
@RequestMapping("manage")
public class SystemManageController {

    @Resource
    private PropertyJobBusiness propertyJobBusiness;

    @RequestMapping("billJob")
    public GenericResponse generateBillJob() {

        return propertyJobBusiness.generateMonthBill();
    }

    @RequestMapping("billPlanJob")
    public GenericResponse generateBillPlanJob() {

        return propertyJobBusiness.generateBillPlan();
    }
}
