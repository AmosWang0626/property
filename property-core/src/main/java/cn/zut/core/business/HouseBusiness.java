package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.BusinessCarSetEntity;
import cn.zut.dao.entity.BusinessHouseRentEntity;

/**
 *
 *
 * @author liubowen
 */
public interface HouseBusiness {


    /**
     * 获取用户信息用户
     *
     * @param pageModel 忘记密码表单
     * @return 通用
     */
    SimplePageResult<BusinessHouseRentEntity> pageMemberByModel(PageModel<BusinessHouseRentEntity> pageModel);

}
