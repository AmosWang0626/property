package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.constant.PropertyConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@RequestMapping("web")
@RestController
public class WebController {

    /**
     * test get
     *
     * @return String
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public GenericResponse get(HttpServletRequest request) {
        return new GenericResponse<>(request.getHeader(PropertyConstant.TOKEN));
    }

    /**
     * test post
     *
     * @return String
     */
    @RequestMapping(value = "post", method = RequestMethod.POST)
    public GenericResponse post(@RequestParam(value = "hello", required = false) String hello, HttpServletRequest request) {
        return new GenericResponse<>(request.getHeader(PropertyConstant.TOKEN) + "\n" + hello);
    }
}
