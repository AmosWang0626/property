package cn.zut.core.service;

import cn.zut.common.request.RegisterRequest;
import cn.zut.common.response.GenericResponse;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberService {

    /**
     * 保存用户信息
     *
     * @param registerRequest 注册表单
     * @return 通用
     */
    GenericResponse save(RegisterRequest registerRequest);

}
