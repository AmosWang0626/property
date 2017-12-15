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

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author sunyafei
 */
@Component("memberInterceptor")
public class MemberInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
