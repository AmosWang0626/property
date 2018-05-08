package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.MenuRolesEntity;

import java.util.List;

/**
 * @author DaoyuanWang
 */
public interface MenuRolesMapper extends
        Insert<MenuRolesEntity>,
        Update<MenuRolesEntity>,
        DeleteById<Integer>,
        SelectByExample<MenuRolesEntity, MenuRolesEntity>,
        SelectListByExample<MenuRolesEntity, MenuRolesEntity>,
        SelectCountByExample<MenuRolesEntity>,
        SelectListPageByExample<MenuRolesEntity, MenuRolesEntity> {

    List<MenuRolesEntity> selectById(Integer roleId);

}