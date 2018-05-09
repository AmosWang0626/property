package cn.zut.web.controller;

import cn.zut.core.business.MemberBusiness;
import cn.zut.core.service.BusinessRolesUserService;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author LiuBowen
 */
@Controller
@RequestMapping("roles")
public class BusinessRolesController {

    @Resource
    private MemberBusiness memberBusiness;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private BusinessRolesUserService businessRolesUserService;

    @RequestMapping("roleget")
    public String roleGet(Long memberId, HttpServletRequest request) {
        MemberEntity memberEntity = memberMapper.selectById(memberId);
        request.setAttribute("memberEntity", memberEntity);
        BusinessRolesEntity businessRolesEntity = businessRolesUserService.getRoles(memberId);
        System.out.println(businessRolesEntity.getRolesName());
        request.setAttribute("memberroles", businessRolesEntity);
        return "changeRoles";
    }

    @RequestMapping("changeRole")
    public String roleChange(Integer roleId, Long memberId, HttpServletRequest request) {
        boolean flag = businessRolesUserService.updateRoles(roleId, memberId);
        if (flag) {
            // TODO msg
            request.setAttribute("msg", "666");
        }
        return "changeRoles";
    }
}
