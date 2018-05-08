package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.RolesEntity;

public interface RolesMapper extends
        Insert<RolesEntity>,
        Update<RolesEntity>,
        DeleteById<Integer>,
        SelectById<RolesEntity, Integer>,
        SelectCountByExample<RolesEntity>,
        SelectListPageByExample<RolesEntity, RolesEntity> {

}