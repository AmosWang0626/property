package cn.zut.web.controller;

import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.facade.constant.PropertyConstant;
import cn.zut.facade.request.LoginRequest;
import cn.zut.facade.response.LoginResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

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

    /**
     * 用户登录
     *
     * @return String
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public GenericResponse login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }
        if ("18937128861".equals(loginRequest.getPhoneNo()) && "123456".equals(loginRequest.getPassword())) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken("SDK666PDF");
            loginResponse.setNickName("DY" + new Random().nextInt(10));
            loginResponse.setPhoneNo("189****8861");
            return new GenericResponse<>(loginResponse);
        }
        return new GenericResponse<>(new ExceptionMessage(ExceptionCode.MEMBER_PASSWORD_ERROR));
    }

}
