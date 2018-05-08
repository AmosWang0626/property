package cn.zut.core.service;

import cn.zut.dao.entity.MenusEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface MenusService {
    List<MenusEntity> getAllMenus(List<Integer> menus);
}
