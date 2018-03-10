package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @apiNote 基础Controller, 其他Controller的父类
 * @date 2018/3/10
 */
public class BaseController {

    /**
     * 通用方法, 服务于cn.zut.web.controller.*Controller
     *
     * @param viewName        要跳转的网页名称
     * @param genericResponse 通用的返回给网页的对象
     * @return ModelAndView
     */
    protected ModelAndView genericReturn(String viewName, GenericResponse genericResponse) {
        return new ModelAndView(viewName, "GenericResponse", genericResponse);
    }
}
