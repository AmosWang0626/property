package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.PageResult;
import cn.zut.common.request.ForgetPwdRequest;
import cn.zut.common.request.LoginRequest;
import cn.zut.common.request.RegisterRequest;
import cn.zut.common.response.LoginResponse;
import cn.zut.core.business.MemberBusiness;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.search.MemberSearch;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("UserLogin", "GenericResponse",
                new GenericResponse(new ExceptionMessage(ExceptionCode.PLEASE_INPUT_PHONE_NO_AND_PASSWORD)));
    }

    /**
     * 用户注册
     *
     * @return 注册状态
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute RegisterRequest registerRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new ModelAndView("UserLogin", "GenericResponse",
                    new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage())));
        }

        return new ModelAndView("UserLogin", "GenericResponse", memberBusiness.register(registerRequest));
    }

    /**
     * 用户登录
     *
     * @return 登录状态
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView realLogin(@ModelAttribute LoginRequest loginRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new ModelAndView("UserLogin", "GenericResponse",
                    new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage())));
        }

        GenericResponse<LoginResponse> genericResponse = memberBusiness.login(loginRequest);
        if (genericResponse.success()) {
            PageModel<MemberSearch> pageModel = new PageModel<>();
            pageModel.setPage(1);
            pageModel.setRows(5);
            PageResult<MemberEntity> pageResult = memberBusiness.pageMemberByModel(pageModel);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("pageResult", pageResult);
            modelAndView.addObject("GenericResponse", genericResponse);
            modelAndView.setViewName("UserManagePage");
            return modelAndView;
        } else {
            return new ModelAndView("UserLogin", "GenericResponse", genericResponse);
        }
    }

    /**
     * 用户忘记密码
     */
    @RequestMapping(value = "forgetPassword", method = RequestMethod.POST)
    public ModelAndView forgetPassword(@ModelAttribute ForgetPwdRequest forgetPwdRequest) {
        String phoneNo = forgetPwdRequest.getPhoneForgetPwd();

        if (StringUtils.isBlank(phoneNo)) {
            return new ModelAndView("UserLogin", "GenericResponse",
                    new GenericResponse<>(new ExceptionMessage(ExceptionCode.PLEASE_INPUT_PHONE_NO)));
        }

        return new ModelAndView("UserLogin", "GenericResponse",
                memberBusiness.updatePwd(forgetPwdRequest));
    }

    @GetMapping("page")
    public ModelAndView pageApply(@RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return new ModelAndView("UserLogin");
        }
        PageModel<MemberSearch> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        PageResult<MemberEntity> pageResult = memberBusiness.pageMemberByModel(pageModel);
        ModelAndView modelAndView = new ModelAndView();
        // 缓兵之计, 临时写法
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setNickName("管理员");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("GenericResponse", new GenericResponse<>(loginResponse));
        modelAndView.setViewName("UserManagePage");

        return modelAndView;
    }
}
