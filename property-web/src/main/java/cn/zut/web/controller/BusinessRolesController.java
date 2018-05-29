package cn.zut.web.controller;

import cn.zut.common.generic.GenericResponse;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.BusinessMenusService;
import cn.zut.core.service.BusinessRolesUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuBowen
 */
@Controller
@RequestMapping("roles")
public class BusinessRolesController {

    @Resource
    private BusinessMenusService businessMenusService;

    @Resource
    private BusinessRolesUserService businessRolesUserService;

    /**
     * 用户登录
     *
     * @return 登录状态
     */
    @RequestMapping(value = "menu", method = RequestMethod.GET)
    @ResponseBody
    public GenericResponse menu(HttpServletRequest request) {
        return businessRolesUserService.getMenus(getMemberId(request));
    }

    @RequestMapping("hasFatherMenus")
    public GenericResponse hasFatherMenus() {
        return new GenericResponse<>(businessMenusService.haveFatherIdMenus());
    }

    @RequestMapping("menusByRole")
    public GenericResponse menusByRole(@RequestParam("rolesId") Integer rolesId) {
        return new GenericResponse<>(businessMenusService.menus(rolesId));
    }

    @RequestMapping("allRole")
    public GenericResponse menusByRole() {
        return new GenericResponse<>(businessMenusService.allRole());
    }

    @RequestMapping("changeRole")
    public GenericResponse roleChange(Integer roleId, Long memberId) {

        return businessRolesUserService.updateRoles(roleId, memberId) ?
                GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }
}
