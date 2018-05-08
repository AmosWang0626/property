package cn.zut.web.controller;

import cn.zut.common.api.Token;
import cn.zut.common.dao.PageModel;
import cn.zut.core.business.MemberBusiness;
import cn.zut.core.service.BusinessRolesUserService;
import cn.zut.core.service.TariffMothConsumeService;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.MemberMapper;
import cn.zut.dao.search.MemberSearch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    @Resource
    private TariffMothConsumeService tariffMothConsumeService;

    @RequestMapping("usersRoles")
    @Token(check = false)
    @ResponseBody
    private Map<String, Object> userRole() {
        PageModel<MemberSearch> pageModel = new PageModel<>();
        pageModel.setPage(1);
        pageModel.setRows(100);

        Map<String, Object> resuletMap = new HashMap<>();
        resuletMap.put("data", memberBusiness.pageMemberByModel(pageModel));
        resuletMap.put("msg", "");
        resuletMap.put("code", "0");

        return resuletMap;
    }

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
    public String roleChange(Integer roleid, Long memberid, HttpServletRequest request) {
        boolean flag = businessRolesUserService.updateRoles(roleid, memberid);
        if (flag) {
            // TODO msg
            request.setAttribute("msg", "666");
        }
        return "changeRoles";
    }
}
