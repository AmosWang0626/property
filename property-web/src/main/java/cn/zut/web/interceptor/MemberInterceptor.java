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
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author daoyuan
 */
@Component("memberInterceptor")
public class MemberInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader(PropertyConstant.TOKEN);
        /*String deviceId = request.getHeader(PropertyConstant.DEVICE_ID);*/
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        // 如果不需要校验直接 return true
//        if (!needTokenCheck(handlerMethod)) {
//            return true;
//        }
//        if (token == null) {
//            throw new UserTokenException("参数校验异常! 没有登录!");
//        }
//        String memberId = DesEncryptionUtil.decrypt(token, PropertyConstant.TOKEN_ENCRYPT);
//        if (memberId == null) {
//            throw new UserTokenException("参数校验异常! 用户Token异常!");
//        }
//        request.setAttribute(PropertyConstant.MEMBER_ID, memberId);
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
