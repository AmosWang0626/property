package cn.zut.core.job;

import cn.zut.core.business.TariffBillBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/25
 */
@Component
public class GenerateBillPlanJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateBillPlanJob.class);

    @Resource
    private TariffBillBusiness tariffBillBusiness;

    /**
     * 生成cron网址: http://cron.qqe2.com/
     * "* * * * * ?" 每隔1秒执行一次
     * "0 0/3 * * * ?" 每3分钟执行一次
     * "0 0,20,40 0 1 * ?" 每天[00:00, 00:20, 00:40]执行, 每月三次
     * "0 0,20,40 1 * * ?" 每天[01:00, 01:20, 01:40]执行, 每天三次
     */
    @Scheduled(cron = "0 0,20,40 1 * * ?")
    public void generateBillPlan() {
        long startTime = System.currentTimeMillis();
        LOGGER.info("-------------- Generate plan to start execution! --------");
        tariffBillBusiness.generateBillPlan();
        LOGGER.info("-------------- End of generation plan execution! Time-consuming[ " +
                (System.currentTimeMillis() - startTime) + " milliseconds]--------");
    }
}