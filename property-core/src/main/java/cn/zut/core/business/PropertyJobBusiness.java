package cn.zut.core.business;

import cn.zut.common.generic.GenericResponse;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/18
 */
public interface PropertyJobBusiness {

    /**
     * 生成月度账单
     *
     * @return GenericResponse
     */
    GenericResponse generateMonthBill();

    /**
     * 生成账单还款计划
     *
     * @return GenericResponse
     */
    GenericResponse generateBillPlan();

    /**
     * 更新账单从待还款2逾期
     *
     * @return GenericResponse
     */
    GenericResponse updateBillPlan2OverDue();

    /**
     * 每天更新逾期费
     *
     * @return GenericResponse
     */
    GenericResponse updateOverDueBillPlan();

}
