package cn.zut.web.controller;

import cn.zut.common.api.ComboVO;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.constant.PropertyConstant;
import cn.zut.core.service.BusinessMenusService;
import cn.zut.core.service.BusinessRolesUserService;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.facade.request.ManageRoleChangeRequest;
import cn.zut.facade.response.ManageRoleMenus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBowen
 */
@RestController
@RequestMapping("roles")
public class BusinessRolesController {

    @Resource
    private BusinessMenusService businessMenusService;

    @Resource
    private BusinessRolesUserService businessRolesUserService;

    /**
     * 根据用户编号动态获得菜单
     */
    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public GenericResponse menu(HttpServletRequest request) {
        return businessRolesUserService.getMenus(getMemberId(request));
    }

    /**
     * 获取所有含有父 menu 的菜单
     */
    @RequestMapping("hasFatherMenus")
    public GenericResponse hasFatherMenus() {
        List<ManageRoleMenus> manageRoleMenus = new ArrayList<>();
        List<BusinessMenusEntity> businessMenusEntities = businessMenusService.haveFatherIdMenus();
        businessMenusEntities.forEach(businessMenusEntity ->
                manageRoleMenus.add(
                        new ManageRoleMenus(
                                businessMenusEntity.getMenuId(),
                                businessMenusEntity.getFatherId() + businessMenusEntity.getMenuName() + businessMenusEntity.getMenuId()
                        )
                )
        );
        return new GenericResponse<>(manageRoleMenus);
    }

    /**
     * 根据角色id获取授权的菜单
     *
     * @param rolesId 角色id
     */
    @RequestMapping("menusByRole")
    public GenericResponse menusByRole(@RequestParam("rolesId") Integer rolesId) {
        List<Integer> manageRoleMenus = new ArrayList<>();
        List<BusinessMenusEntity> menus = businessMenusService.menus(rolesId);
        if (menus == null) {
            return GenericResponse.SUCCESS;
        }
        menus.forEach(businessMenusEntity -> manageRoleMenus.add(businessMenusEntity.getMenuId()));
        return new GenericResponse<>(manageRoleMenus);
    }

    /**
     * 获取所有角色
     */
    @RequestMapping("allRole")
    public GenericResponse allRole() {
        List<ComboVO> comboVOList = new ArrayList<>();
        List<BusinessRolesEntity> businessRolesEntities = businessMenusService.allRole();
        for (BusinessRolesEntity rolesEntity : businessRolesEntities) {
            comboVOList.add(new ComboVO<>(rolesEntity.getRolesId(), rolesEntity.getRolesDesc()));
        }
        return new GenericResponse<>(comboVOList);
    }

    /**
     * 改变用户角色
     *
     * @return 改变结果
     */
    @RequestMapping("changeRole")
    public GenericResponse changeRole(Integer roleId, Long memberId) {

        return businessRolesUserService.updateRoles(roleId, memberId) ?
                GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    /**
     * 改变角色支持操作的菜单
     *
     * @return 改变结果
     */
    @RequestMapping(value = "changeRoleMenus", method = RequestMethod.POST)
    public GenericResponse changeRoleMenus(@RequestBody ManageRoleChangeRequest manageRoleChangeRequest) {
        // 检验参数
        if (StringUtils.isEmpty(manageRoleChangeRequest.getDirection())
                || manageRoleChangeRequest.getRolesId() == null
                || CollectionUtils.isEmpty(manageRoleChangeRequest.getMenuIds())) {
            return GenericResponse.ERROR_PARAM;
        }

        return businessRolesUserService.updateRoleMenes(manageRoleChangeRequest) ?
                GenericResponse.SUCCESS : GenericResponse.FAIL;
    }

    private Long getMemberId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute(PropertyConstant.MEMBER_ID));
    }
}
