package cn.zut.core.service;

import cn.zut.dao.entity.CarSetEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface CarSetService {
    boolean addCarSet(CarSetEntity carSetEntity);

    List<CarSetEntity> carList();

    CarSetEntity searchCarSet(int id);

    boolean rentCar(CarSetEntity carSetEntity);
}
