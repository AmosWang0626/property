package cn.zut.core.service;

import cn.zut.dao.entity.TariffMonthConsumeEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author LiuBowen
 */
public interface TariffMothConsumeService {

    List<TariffMonthConsumeEntity> getAllUsers();

    boolean updateByWater(Integer memberId, BigDecimal water);

    boolean updateByElectric(Integer memberId, BigDecimal electric);

    boolean updateByProperty(Integer memberId, BigDecimal property);

    boolean updateByInternet(Integer memberId, Boolean internet);

}
