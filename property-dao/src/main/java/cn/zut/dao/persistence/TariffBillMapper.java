package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffBillEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface TariffBillMapper extends Insert<TariffBillEntity>, Update<TariffBillEntity>,
        SelectById<TariffBillEntity, Long>, SelectByExample<TariffBillEntity, TariffBillEntity>,
        SelectCountByExample<TariffBillEntity>, SelectListPageByExample<TariffBillEntity, TariffBillEntity> {
}
