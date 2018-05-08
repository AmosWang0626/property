package cn.zut.core.service;

import cn.zut.dao.entity.BusinessMenusEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface BusinessMenusService {
    List<BusinessMenusEntity> getAllMenus(List<Integer> menus);
}
