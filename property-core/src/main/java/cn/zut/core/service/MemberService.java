package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.dao.entity.MenusEntity;
import cn.zut.facade.request.RegisterRequest;

import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberService {

    /**
     * 保存用户信息
     *
     * @param registerRequest 注册表单
     * @return 通用
     */
    GenericResponse<Long> save(RegisterRequest registerRequest);

    /**
     * 根据用户id查找对应菜单表
     */
    List<MenusEntity> getMenus(Long menuId);

}
