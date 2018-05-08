package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.MenusEntity;
import cn.zut.dao.search.BusinessMenusSearch;

/**
 * @author LiuBowen
 */
public interface MenusMapper extends
        Insert<MenusEntity>,
        Update<MenusEntity>,
        DeleteById<Integer>,
        SelectById<MenusEntity, Integer>,
        SelectByExample<MenusEntity, BusinessMenusSearch>,
        SelectListByExample<MenusEntity, BusinessMenusSearch>,
        SelectCountByExample<BusinessMenusSearch>,
        SelectListPageByExample<MenusEntity, BusinessMenusSearch> {

}