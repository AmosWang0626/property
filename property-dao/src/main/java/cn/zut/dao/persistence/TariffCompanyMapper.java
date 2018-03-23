package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffCompanyEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface TariffCompanyMapper extends Insert<TariffCompanyEntity>, Update<TariffCompanyEntity>,
        SelectById<TariffCompanyEntity, Long>, SelectByExample<TariffCompanyEntity, TariffCompanyEntity>,
        SelectCountByExample<TariffCompanyEntity>, SelectListPageByExample<TariffCompanyEntity, TariffCompanyEntity> {
}
