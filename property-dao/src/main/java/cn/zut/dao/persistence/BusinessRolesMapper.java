package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessRolesEntity;

public interface BusinessRolesMapper extends
        Insert<BusinessRolesEntity>,
        Update<BusinessRolesEntity>,
        DeleteById<Integer>,
        SelectById<BusinessRolesEntity, Integer>,
        SelectCountByExample<BusinessRolesEntity>,
        SelectListPageByExample<BusinessRolesEntity, BusinessRolesEntity> {

}