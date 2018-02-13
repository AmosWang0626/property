package cn.zut.web.controller;

import cn.zut.common.request.ForgetPwdRequest;
import cn.zut.common.request.LoginRequest;
import cn.zut.common.request.RegisterRequest;
import cn.zut.common.response.GenericResponse;
import cn.zut.core.business.MemberBusiness;
import cn.zut.facade.exception.ExceptionCode;
import cn.zut.facade.exception.ExceptionMessage;
import cn.zut.facade.response.LoginVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@RequestMapping("passport")
@Controller
public class MemberController {

    @Resource
    private MemberBusiness memberBusiness;

    /**
     * 跳转到用户登录
     *
     * @return jsp路径
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "UserLogin";
    }

    /**
     * 用户注册
     *
     * @return 注册状态
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute RegisterRequest registerRequest, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            modelAndView.addObject("user_login", new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
            modelAndView.setViewName("UserLogin");
        }

        GenericResponse register = memberBusiness.register(registerRequest);
        if (register.success()) {
            modelAndView.addObject("user_login", registerRequest.getNameRegister());
            // redirect:product
            modelAndView.setViewName("ProductPage");
        } else {
            modelAndView.addObject("user_login", register.getRespMsg());
            modelAndView.setViewName("UserLogin");
        }
        return modelAndView;
    }

    /**
     * 用户登录
     *
     * @return 登录状态
     */
    @RequestMapping(value = "realLogin", method = RequestMethod.POST)
    public ModelAndView realLogin(@ModelAttribute LoginRequest loginRequest, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            modelAndView.addObject("user_login", new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
            modelAndView.setViewName("UserLogin");
        }

        GenericResponse<LoginVO> login = memberBusiness.login(loginRequest);
        if (login.success()) {
            LoginVO loginVO = login.getBody();
            modelAndView.addObject("user_login", loginVO.getNickName());
            // redirect:product
            modelAndView.setViewName("ProductPage");
        } else {
            modelAndView.addObject("user_login", login.getRespMsg());
            modelAndView.setViewName("UserLogin");
        }

        return modelAndView;
    }

    /**
     * 用户忘记密码
     */
    @RequestMapping(value = "forgetPassword", method = RequestMethod.POST)
    public ModelAndView forgetPassword(@ModelAttribute ForgetPwdRequest forgetPwdRequest) {
        String phoneNo = forgetPwdRequest.getPhoneForgetPwd();

        if (StringUtils.isBlank(phoneNo)) {
            return new ModelAndView("UserLogin", "user_login", "请先输入手机号");
        }

        GenericResponse updatePwd = memberBusiness.updatePwd(forgetPwdRequest);
        if (updatePwd.success()) {
            return new ModelAndView("UserLogin", "user_login", "密码修改成功,请重新登录");
        }

        return new ModelAndView("UserLogin", "user_login", updatePwd.getRespMsg());
    }
}
