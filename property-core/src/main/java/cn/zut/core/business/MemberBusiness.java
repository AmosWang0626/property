package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.search.MemberSearch;
import cn.zut.facade.request.LoginRequest;
import cn.zut.facade.request.RegisterRequest;
import cn.zut.facade.request.ResetPasswordRequest;
import cn.zut.facade.response.LoginResponse;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberBusiness {
    /**
     * 用户注册
     *
     * @param registerRequest 注册表单
     * @return 通用
     */
    GenericResponse<LoginResponse> register(RegisterRequest registerRequest);

    /**
     * 用户登录
     *
     * @param loginRequest 登录表单
     * @return 通用
     */
    GenericResponse<LoginResponse> login(LoginRequest loginRequest);

    /**
     * 用户忘记密码
     *
     * @param resetPasswordRequest 忘记密码表单
     * @return 通用
     */
    GenericResponse<LoginResponse> updatePwd(ResetPasswordRequest resetPasswordRequest);

    /**
     * 获取用户信息用户
     *
     * @param pageModel 忘记密码表单
     * @return 通用
     */
    SimplePageResult<MemberEntity> pageMemberByModel(PageModel<MemberSearch> pageModel);
}
