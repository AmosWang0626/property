package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessMenuRolesEntity;

import java.util.List;

/**
 * @author DaoyuanWang
 */
public interface BusinessMenuRolesMapper extends
        Insert<BusinessMenuRolesEntity>,
        Update<BusinessMenuRolesEntity>,
        DeleteById<Integer>,
        SelectByExample<BusinessMenuRolesEntity, BusinessMenuRolesEntity>,
        SelectListByExample<BusinessMenuRolesEntity, BusinessMenuRolesEntity>,
        SelectCountByExample<BusinessMenuRolesEntity>,
        SelectListPageByExample<BusinessMenuRolesEntity, BusinessMenuRolesEntity> {

    List<BusinessMenuRolesEntity> selectById(Integer roleId);

}