package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffBillPlanEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface TariffBillPlanMapper extends
        Insert<TariffBillPlanEntity>,
        BatchInsert<TariffBillPlanEntity>,
        Update<TariffBillPlanEntity>,
        SelectById<TariffBillPlanEntity, Long>,
        SelectByExample<TariffBillPlanEntity, TariffBillPlanEntity>,
        SelectListByExample<TariffBillPlanEntity, TariffBillPlanEntity>,
        SelectCountByExample<TariffBillPlanEntity>,
        SelectListPageByExample<TariffBillPlanEntity, TariffBillPlanEntity> {
}
