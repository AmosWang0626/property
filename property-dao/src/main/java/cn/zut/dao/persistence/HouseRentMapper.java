package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.HouseRentEntity;

public interface HouseRentMapper extends
        Insert<HouseRentEntity>,
        Update<HouseRentEntity>,
        DeleteById<Integer>,
        SelectById<HouseRentEntity, Integer>,
        SelectByExample<HouseRentEntity, HouseRentEntity>,
        SelectListByExample<HouseRentEntity, HouseRentEntity>,
        SelectCountByExample<HouseRentEntity>,
        SelectListPageByExample<HouseRentEntity, HouseRentEntity> {
}