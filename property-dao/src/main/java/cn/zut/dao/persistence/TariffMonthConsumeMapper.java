package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffMonthConsumeEntity;

/**
 * @author DaoyuanWang
 */
public interface TariffMonthConsumeMapper extends
        Insert<TariffMonthConsumeEntity>,
        Update<TariffMonthConsumeEntity>,
        DeleteById<Integer>,
        SelectById<TariffMonthConsumeEntity, Integer>,
        SelectByExample<TariffMonthConsumeEntity, TariffMonthConsumeEntity>,
        SelectListByExample<TariffMonthConsumeEntity, TariffMonthConsumeEntity>,
        SelectCountByExample<TariffMonthConsumeEntity>,
        SelectListPageByExample<TariffMonthConsumeEntity, TariffMonthConsumeEntity> {

}