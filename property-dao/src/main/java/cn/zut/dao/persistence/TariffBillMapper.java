package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffBillEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface TariffBillMapper extends
        Insert<TariffBillEntity>,
        BatchInsert<TariffBillEntity>,
        Update<TariffBillEntity>,
        BatchUpdate<TariffBillEntity>,
        SelectById<TariffBillEntity, Long>,
        SelectByExample<TariffBillEntity, TariffBillEntity>,
        SelectListByExample<TariffBillEntity, TariffBillEntity>,
        SelectCountByExample<TariffBillEntity>,
        SelectListPageByExample<TariffBillEntity, TariffBillEntity> {

    /**
     * totalAmountByMonth
     *
     * @return List
     */
    List<TariffBillEntity> totalAmountByMonth(@Param("month") String month);
}
