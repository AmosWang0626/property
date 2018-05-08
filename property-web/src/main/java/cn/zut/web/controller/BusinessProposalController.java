package cn.zut.web.controller;

import cn.zut.core.service.BusinessProposalService;
import cn.zut.dao.entity.BusinessProposalEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
@Controller
@RequestMapping("proposal")
public class BusinessProposalController {

    @Resource
    private BusinessProposalService businessProposalService;

    /**
     * 保存建议
     */
    @RequestMapping("save")
    public String saveProposal(BusinessProposalEntity businessProposalEntity, HttpServletRequest request) {
        businessProposalService.saveProposal(businessProposalEntity);
        request.setAttribute("businessProposalEntity", "意见提交成功！");
        return "success";
    }

    /**
     * 查看所有建议
     */
    @ResponseBody
    @RequestMapping("findAll")
    public Map<String, Object> findAll() {
        List<BusinessProposalEntity> list = businessProposalService.findAll();
        Map<String, Object> resuletMap = new HashMap<>();
        resuletMap.put("data", list);
        resuletMap.put("msg", "");
        resuletMap.put("code", "0");
        return resuletMap;
    }

    /**
     * 查看指定建议
     */
    @RequestMapping("search")
    @ResponseBody
    public BusinessProposalEntity search(int id) {
        return businessProposalService.search(id);
    }
}
