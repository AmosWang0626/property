package cn.zut.core.service;

import cn.zut.dao.entity.BusinessHouseRentEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface BusinessHouseService {
    List<BusinessHouseRentEntity> houseRentList();

    boolean deleteById(int id);

    BusinessHouseRentEntity getById(int id);

    boolean addHouse(BusinessHouseRentEntity businessHouseRentEntity);
}
