package cn.zut.core.business;

import cn.zut.common.request.ForgetPwdRequest;
import cn.zut.common.request.LoginRequest;
import cn.zut.common.request.RegisterRequest;
import cn.zut.common.response.GenericResponse;
import cn.zut.facade.response.LoginVO;

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
    GenericResponse register(RegisterRequest registerRequest);

    /**
     * 用户登录
     *
     * @param loginRequest 登录表单
     * @return 通用
     */
    GenericResponse<LoginVO> login(LoginRequest loginRequest);

    /**
     * 用户忘记密码
     *
     * @param forgetPwdRequest 忘记密码表单
     * @return 通用
     */
    GenericResponse updatePwd(ForgetPwdRequest forgetPwdRequest);
}
