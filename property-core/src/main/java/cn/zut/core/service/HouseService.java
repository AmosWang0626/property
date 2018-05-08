package cn.zut.core.service;

import cn.zut.dao.entity.HouseRentEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface HouseService {
    List<HouseRentEntity> houseRentList();

    boolean deleteById(int id);

    HouseRentEntity getById(int id);

    boolean addHouse(HouseRentEntity houseRentEntity);
}
