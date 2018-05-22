package cn.zut.core.job;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.PropertyJobBusiness;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PROJECT: property
 * DESCRIPTION: 定时任务JOB
 * 生成cron网址: http://cron.qqe2.com/
 * "* * * * * ?" 每隔1秒执行一次
 * "0 0/3 * * * ?" 每3分钟执行一次
 * "0 0,20,40 0 1 * ?" 每天[00:00, 00:20, 00:40]执行, 每月三次
 * "0 0,20,40 1 * * ?" 每天[01:00, 01:20, 01:40]执行, 每天三次
 *
 * @author DaoYuanWang
 * @date 2018/4/25
 */
@Component
public class GenerateBillPlanJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateBillPlanJob.class);

    @Resource
    private PropertyJobBusiness propertyJobBusiness;

    /**
     * 生成账单计划
     */
    @Scheduled(cron = "0 0,20,40 1 * * ?")
    public void generateBill() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("-------------- Generate plan to start execution! --------");
        GenericResponse genericResponse = propertyJobBusiness.generateMonthBill();
        LOGGER.info("-------------- End of generation plan execution! Time-consuming[ " +
                (System.currentTimeMillis() - startTime) + " milliseconds]--------");
        LOGGER.info("---------------Run Result: " + JSON.toJSONString(genericResponse));
    }

    /**
     * 生成账单计划
     */
    @Scheduled(cron = "0 0,20,40 1 * * ?")
    public void generateBillPlan() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("-------------- Generate plan to start execution! --------");
        GenericResponse genericResponse = propertyJobBusiness.generateBillPlan();
        LOGGER.info("-------------- End of generation plan execution! Time-consuming[ " +
                (System.currentTimeMillis() - startTime) + " milliseconds]--------");
        LOGGER.info("---------------Run Result: " + JSON.toJSONString(genericResponse));
    }

    /**
     * 每月1*日到期修改用户账单
     */
    @Scheduled(cron = "0 0,20,40 1 * * ?")
    public void updateBillPlan2OverDue() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("-------------- Update Repaying to Overdue Bill to start execution! --------");
        GenericResponse genericResponse = propertyJobBusiness.updateBillPlanStatus();
        LOGGER.info("-------------- End of Update Repaying to Overdue Bill execution! Time-consuming[ " +
                (System.currentTimeMillis() - startTime) + " milliseconds]--------");
        LOGGER.info("---------------Run Result: " + JSON.toJSONString(genericResponse));
    }

    /**
     * 每天更新逾期费
     */
    @Scheduled(cron = "0 0,20,40 1 * * ?")
    public void updateOverDueBillPlan() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("-------------- Update Overdue Bill to start execution! --------");
        GenericResponse genericResponse = propertyJobBusiness.updateBillPlanAmount();
        LOGGER.info("-------------- End of Update Overdue Bill execution! Time-consuming[ " +
                (System.currentTimeMillis() - startTime) + " milliseconds]--------");
        LOGGER.info("---------------Run Result: " + JSON.toJSONString(genericResponse));
    }
}