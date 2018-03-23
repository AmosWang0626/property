package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffStandardEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface TariffStandardMapper extends Insert<TariffStandardEntity>, Update<TariffStandardEntity>,
        SelectById<TariffStandardEntity, Long>, SelectByExample<TariffStandardEntity, TariffStandardEntity>,
        SelectCountByExample<TariffStandardEntity>, SelectListPageByExample<TariffStandardEntity, TariffStandardEntity> {
}
