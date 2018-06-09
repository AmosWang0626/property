package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.TariffConsumeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/4/17
 */
public interface TariffConsumeMapper extends Insert<TariffConsumeEntity>, Update<TariffConsumeEntity>,
        SelectById<TariffConsumeEntity, Long>, SelectByExample<TariffConsumeEntity, TariffConsumeEntity>,
        SelectCountByExample<TariffConsumeEntity>, SelectListPageByExample<TariffConsumeEntity, TariffConsumeEntity> {

    /**
     * totalAmountByMonth
     *
     * @return List
     */
    List<TariffConsumeEntity> totalAmountByMonth(@Param("month") String month);
}
