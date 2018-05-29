package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.BusinessCarSetEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.search.MemberSearch;
import cn.zut.facade.request.*;
import cn.zut.facade.response.LoginResponse;

/**
 *
 *
 * @author liubowen
 */
public interface CarBusiness {


    /**
     * 获取用户信息用户
     *
     * @param pageModel 忘记密码表单
     * @return 通用
     */
    SimplePageResult<BusinessCarSetEntity> pageMemberByModel(PageModel<BusinessCarSetEntity> pageModel);

}
