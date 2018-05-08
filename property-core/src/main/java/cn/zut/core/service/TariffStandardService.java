package cn.zut.core.service;

import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.entity.TariffBillPlanEntity;
import cn.zut.dao.entity.TariffStandardEntity;

/**
 * @author LiuBowen
 */
public interface TariffStandardService {
    boolean waterSet(TariffStandardEntity tariffStandardEntity);

    boolean internetSet(TariffStandardEntity tariffStandardEntity);

    boolean electricSet(TariffStandardEntity tariffStandardEntity);

    boolean propertySet(TariffStandardEntity tariffStandardEntity);

    TariffBillPlanEntity getWater(MemberEntity memberEntity, String water);
}
