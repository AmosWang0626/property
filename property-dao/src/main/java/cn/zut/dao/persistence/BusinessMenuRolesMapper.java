package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessMenuRolesEntity;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据id查询角色支持的菜单id
     *
     * @param roleId 角色id
     * @return List<BusinessMenuRolesEntity>
     */
    List<BusinessMenuRolesEntity> selectById(Integer roleId);

    /**
     * 插入多条数据
     *
     * @param list List<BusinessMenuRolesEntity>
     * @return 插入条数
     */
    Integer batchInsert(List<BusinessMenuRolesEntity> list);

    /**
     * 删除多条数据
     *
     * @param list List<BusinessMenuRolesEntity>
     * @return 删除条数
     */
    Integer batchDelete(List<BusinessMenuRolesEntity> list);

    /**
     * 获取需要的一级菜单
     *
     * @param id 角色id
     * @return 需要的一级菜单
     */
    List<Integer> needFirstMenus(Integer id);

    /**
     * 获取所有的一级菜单
     *
     * @return 需要的一级菜单
     */
    List<Integer> selectFirstMenus();

    /**
     * 删除一级菜单数据
     *
     * @param id      角色id
     * @param menuIds 一级菜单id
     * @return 删除条数
     */
    Integer deleteFirstMenus(@Param("id") Integer id, @Param("menuIds") List<Integer> menuIds);
}