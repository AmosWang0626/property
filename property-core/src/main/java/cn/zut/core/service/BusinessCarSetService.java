package cn.zut.core.service;

import cn.zut.dao.entity.BusinessCarSetEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface BusinessCarSetService {
    boolean addCarSet(BusinessCarSetEntity businessCarSetEntity);

    List<BusinessCarSetEntity> carList();

    BusinessCarSetEntity searchCarSet(int id);

    boolean rentCar(BusinessCarSetEntity businessCarSetEntity);
}
