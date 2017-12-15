package cn.zut.core.business;

import cn.zut.common.response.GenericResponse;
import cn.zut.facade.request.ForgetPwdForm;
import cn.zut.facade.request.LoginForm;
import cn.zut.facade.request.RegisterForm;
import cn.zut.facade.response.LoginVO;

/**
 * PROJECT: catherine
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberBusiness {
    /**
     * 用户注册
     *
     * @param registerForm 注册表单
     * @return 通用
     */
    GenericResponse register(RegisterForm registerForm);

    /**
     * 用户登录
     *
     * @param loginForm 登录表单
     * @return 通用
     */
    GenericResponse<LoginVO> login(LoginForm loginForm);

    /**
     * 用户忘记密码
     *
     * @param forgetPwdForm 忘记密码表单
     * @return 通用
     */
    GenericResponse updatePwd(ForgetPwdForm forgetPwdForm);
}
