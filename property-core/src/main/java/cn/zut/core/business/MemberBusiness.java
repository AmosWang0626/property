package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.search.MemberSearch;
import cn.zut.facade.request.*;
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
    GenericResponse<LoginResponse> forgetPassword(ResetPasswordRequest resetPasswordRequest);

    /**
     * 用户修改密码
     *
     * @param updatePasswordRequest 修改密码表单
     * @param memberId              用户编号
     * @return 通用
     */
    GenericResponse updatePassword(UpdatePasswordRequest updatePasswordRequest, Long memberId);

    /**
     * 获取用户信息用户
     *
     * @param pageModel 忘记密码表单
     * @return 通用
     */
    SimplePageResult<MemberEntity> pageMemberByModel(PageModel<MemberSearch> pageModel);

    /**
     * 修改用户信息
     *
     * @param userInfoRequest UserInfoRequest
     * @return GenericResponse
     */
    GenericResponse modifyUserInfo(UserInfoRequest userInfoRequest);

    /**
     * 删除用户
     *
     * @param userInfoRequest UserInfoRequest
     * @return GenericResponse
     */
    GenericResponse deleteUser(UserInfoRequest userInfoRequest);
}
