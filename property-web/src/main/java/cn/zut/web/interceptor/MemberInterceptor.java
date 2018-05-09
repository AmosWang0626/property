/*
 *
 *  * Heng-You Confidential
 *  *
 *  * Copyright (C) 2017 Shanghai Heng-You Information Technology Co., Ltd.
 *  * All rights reserved.
 *  *
 *  * No part of this file may be reproduced or transmitted in any form or by any means,
 *  * electronic, mechanical, photocopying, recording, or otherwise, without prior
 *  * written permission of Shanghai Heng-You Information Technology Co., Ltd.
 *
 *
 */

package cn.zut.web.interceptor;

import cn.zut.common.api.Token;
import cn.zut.common.exception.UserTokenException;
import cn.zut.common.security.DesEncryptionUtil;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.MemberMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author daoyuan
 */
@Component("memberInterceptor")
public class MemberInterceptor implements HandlerInterceptor {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(PropertyConstant.TOKEN);
        String roles = request.getHeader(PropertyConstant.ROLES);
        /*String deviceId = request.getHeader(PropertyConstant.DEVICE_ID);*/
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 如果不需要校验直接 return true
        if (!needTokenCheck(handlerMethod)) {
            return true;
        }
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(roles)) {
            throw new UserTokenException("参数校验异常! 没有登录!");
        }
        String memberId = DesEncryptionUtil.decrypt(token, PropertyConstant.TOKEN_ENCRYPT);
        if (memberId == null) {
            throw new UserTokenException("参数校验异常! 用户Token异常!");
        }
        request.setAttribute(PropertyConstant.MEMBER_ID, memberId);

        // 安全校验,防止用户修改请求的角色编号
        MemberEntity memberEntity = memberMapper.selectById(Long.valueOf(memberId));
        if (memberEntity == null || !memberEntity.getRolesId().equals(Integer.valueOf(roles))) {
            throw new UserTokenException("参数校验异常! 用户Token异常!");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * 是否要检查 TOKEN
     *
     * @param handlerMethod handlerMethod
     * @return 是否需要检查 MEMBER_ID
     */
    private boolean needTokenCheck(HandlerMethod handlerMethod) {
        Method method = handlerMethod.getMethod();
        Token annotation = method.getAnnotation(Token.class);
        return (null == annotation || annotation.check());
    }
}
