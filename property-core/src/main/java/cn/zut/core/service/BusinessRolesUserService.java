package cn.zut.core.service;

import cn.zut.dao.entity.BusinessRolesEntity;

/**
 * @author LiuBowen
 */
public interface BusinessRolesUserService {

    /**
     * 获取用户对应角色 实体类
     *
     * @param memberId 用户编号
     * @return BusinessRolesEntity
     */
    BusinessRolesEntity getRoles(Long memberId);

    /**
     * 修改用户对应角色
     *
     * @param roleId   角色id
     * @param memberId 用户编号
     * @return 设置成功与否
     */
    boolean updateRoles(Integer roleId, Long memberId);
}
