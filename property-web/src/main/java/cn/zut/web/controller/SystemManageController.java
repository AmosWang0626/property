package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.PropertyJobBusiness;
import cn.zut.facade.response.TariffJobsVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public GenericResponse<List<TariffJobsVO>> allJob() {
        List<TariffJobsVO> tariffJobsVOS = new ArrayList<>();
        String[] jobNames = new String[]{"generateBill", "generateBillPlan", "updateBillPlanStatus", "updateBillPlanAmount"};
        String[] jobDescS = new String[]{"生成账单", "生成缴费计划", "更新缴费计划状态", "每天更新逾期费"};
        for (int i = 0, len = 4; i < len; i++) {
            TariffJobsVO tariffJobsVO = new TariffJobsVO();
            tariffJobsVO.setId((long) i);
            tariffJobsVO.setJobName(jobNames[i]);
            tariffJobsVO.setJobDesc(jobDescS[i]);
            tariffJobsVO.setStartTime(new Date());
            tariffJobsVO.setEndTime(new Date());
            tariffJobsVO.setRunTime(tariffJobsVO.getEndTime().getTime() - tariffJobsVO.getStartTime().getTime());
            tariffJobsVO.setStatus("SUCCESS");

            tariffJobsVOS.add(tariffJobsVO);
        }

        return new GenericResponse<>(tariffJobsVOS);
    }

    @RequestMapping(value = "generateBill", method = RequestMethod.GET)
    public GenericResponse generateBill() {

        return propertyJobBusiness.generateMonthBill();
    }

    @RequestMapping(value = "generateBillPlan", method = RequestMethod.GET)
    public GenericResponse generateBillPlan() {

        return propertyJobBusiness.generateBillPlan();
    }

    @RequestMapping(value = "updateBillPlanStatus", method = RequestMethod.GET)
    public GenericResponse updateBillPlanStatus() {

        return propertyJobBusiness.updateBillPlanStatus();
    }

    @RequestMapping(value = "updateBillPlanAmount", method = RequestMethod.GET)
    public GenericResponse updateBillPlanAmount() {

        return propertyJobBusiness.updateBillPlanAmount();
    }
}
