package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessHouseRentEntity;

public interface BusinessHouseRentMapper extends
        Insert<BusinessHouseRentEntity>,
        Update<BusinessHouseRentEntity>,
        DeleteById<Integer>,
        SelectById<BusinessHouseRentEntity, Integer>,
        SelectByExample<BusinessHouseRentEntity, BusinessHouseRentEntity>,
        SelectListByExample<BusinessHouseRentEntity, BusinessHouseRentEntity>,
        SelectCountByExample<BusinessHouseRentEntity>,
        SelectListPageByExample<BusinessHouseRentEntity, BusinessHouseRentEntity> {
}