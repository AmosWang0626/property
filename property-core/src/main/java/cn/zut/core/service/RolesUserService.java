package cn.zut.core.service;

import cn.zut.dao.entity.RolesEntity;

/**
 * @author LiuBowen
 */
public interface RolesUserService {
    /**
     * 获取用户对应角色
     */
    Integer getUserRoles(Long memberId);

    /**
     * 获取对应角色
     */
    RolesEntity getRoles(Long memberId);

    boolean updateRoles(Integer roleId, Long memberId);
}
