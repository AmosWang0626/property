package cn.zut.core.service;

import cn.zut.dao.entity.BusinessMenusEntity;

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
    List<BusinessMenusEntity> getAllMenus(Integer rolesId);
}
