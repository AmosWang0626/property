package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffCompanyBillEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface TariffCompanyBillMapper extends Insert<TariffCompanyBillEntity>, Update<TariffCompanyBillEntity>,
        SelectById<TariffCompanyBillEntity, Long>, SelectByExample<TariffCompanyBillEntity, TariffCompanyBillEntity>,
        SelectCountByExample<TariffCompanyBillEntity>, SelectListPageByExample<TariffCompanyBillEntity, TariffCompanyBillEntity> {
}
