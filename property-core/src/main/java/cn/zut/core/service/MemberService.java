package cn.zut.core.service;

import cn.zut.common.generic.GenericResponse;
import cn.zut.common.request.RegisterRequest;

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
    GenericResponse<Long> save(RegisterRequest registerRequest);

}
