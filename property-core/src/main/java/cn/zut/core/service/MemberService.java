package cn.zut.core.service;


import cn.zut.common.response.GenericResponse;
import cn.zut.facade.request.RegisterForm;

/**
 * PROJECT: catherine
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberService {

    /**
     * 保存用户信息
     *
     * @param registerForm 注册表单
     * @return 通用
     */
    GenericResponse save(RegisterForm registerForm);

}
