package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.facade.request.ManageRoleChangeRequest;
import cn.zut.facade.response.MenuFirstLevelVO;

import java.util.List;

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
     * 修改角色权限对应菜单
     *
     * @param manageRoleChangeRequest 改变的菜单表单
     * @return 设置成功与否
     */
    boolean updateRoleMenes(ManageRoleChangeRequest manageRoleChangeRequest);

    /**
     * 修改用户对应角色
     *
     * @param roleId   角色id
     * @param memberId 用户编号
     * @return 设置成功与否
     */
    boolean updateRoles(Integer roleId, Long memberId);

    /**
     * 根据用户可查看的菜单
     *
     * @param memberId 用户编号
     * @return 二级菜单列表
     */
    GenericResponse<List<MenuFirstLevelVO>> getMenus(Long memberId);
}
