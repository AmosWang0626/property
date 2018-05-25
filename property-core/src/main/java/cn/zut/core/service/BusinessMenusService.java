package cn.zut.core.service;

import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.entity.BusinessRolesEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface BusinessMenusService {

    /**
     * 根据用户角色id,获取菜单信息
     *
     * @param rolesId 用户角色id
     * @return 菜单信息详情
     */
    List<BusinessMenusEntity> menus(Integer rolesId);

    /**
     * 获取含有父id的菜单
     *
     * @return 菜单信息详情 List
     */
    List<BusinessMenusEntity> haveFatherIdMenus();

    /**
     * 获取所有角色
     *
     * @return 角色对象List
     */
    List<BusinessRolesEntity> allRole();
}
