package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.search.BusinessMenusSearch;

/**
 * @author LiuBowen
 */
public interface BusinessMenusMapper extends
        Insert<BusinessMenusEntity>,
        Update<BusinessMenusEntity>,
        DeleteById<Integer>,
        SelectById<BusinessMenusEntity, Integer>,
        SelectByExample<BusinessMenusEntity, BusinessMenusSearch>,
        SelectListByExample<BusinessMenusEntity, BusinessMenusSearch>,
        SelectCountByExample<BusinessMenusSearch>,
        SelectListPageByExample<BusinessMenusEntity, BusinessMenusSearch> {

}