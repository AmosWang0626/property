package cn.zut.core.service;

import cn.zut.dao.entity.BusinessRolesEntity;

/**
 * @author LiuBowen
 */
public interface BusinessRolesUserService {
    /**
     * 获取用户对应角色
     */
    Integer getUserRoles(Long memberId);

    /**
     * 获取对应角色
     */
    BusinessRolesEntity getRoles(Long memberId);

    boolean updateRoles(Integer roleId, Long memberId);
}
