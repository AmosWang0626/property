package cn.zut.web.controller;

import cn.zut.common.api.Token;
import cn.zut.common.dao.PageModel;
import cn.zut.common.exception.ExceptionCode;
import cn.zut.common.exception.ExceptionMessage;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.MemberBusiness;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.MemberService;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.dao.search.MemberSearch;
import cn.zut.facade.request.LoginRequest;
import cn.zut.facade.request.RegisterRequest;
import cn.zut.facade.request.ResetPasswordRequest;
import cn.zut.facade.request.UserInfoRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
@RequestMapping("passport")
@RestController
public class MemberController {

    @Resource
    private MemberBusiness memberBusiness;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private MemberService memberService;

    /**
     * 用户注册
     *
     * @return 注册状态
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @Token(check = false)
    public GenericResponse register(@RequestBody @Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return memberBusiness.register(registerRequest);
    }

    /**
     * 用户登录
     *
     * @return 登录状态
     */
    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public GenericResponse menu(HttpServletRequest request) {
        return memberService.getMenus(getMemberId(request));
    }

    /**
     * 用户登录
     *
     * @return 登录状态
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @Token(check = false)
    public GenericResponse login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return memberBusiness.login(loginRequest);
    }

    /**
     * 用户忘记密码
     */
    @RequestMapping(value = "forgetPassword", method = RequestMethod.POST)
    @Token(check = false)
    public GenericResponse forgetPassword(@RequestBody @Valid ResetPasswordRequest resetPasswordRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return memberBusiness.updatePwd(resetPasswordRequest);
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "modifyUserInfo", method = RequestMethod.POST)
    public GenericResponse modifyUserInfo(@RequestBody @Valid UserInfoRequest userInfoRequest,
                                          BindingResult bindingResult, HttpServletRequest request) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        if (userInfoRequest.getMemberId() == null) {
            userInfoRequest.setMemberId(getMemberId(request));
        }

        return memberBusiness.modifyUserInfo(userInfoRequest);
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    public GenericResponse deleteUser(@RequestBody @Valid UserInfoRequest userInfoRequest, BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return new GenericResponse(new ExceptionMessage(ExceptionCode.PARAM_ERROR, list.get(0).getDefaultMessage()));
        }

        return memberBusiness.deleteUser(userInfoRequest);
    }

    @GetMapping("page")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<MemberSearch> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(memberBusiness.pageMemberByModel(pageModel));
    }

    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }
}
