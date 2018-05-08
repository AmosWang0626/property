package cn.zut.web.controller;

import cn.zut.core.service.ProposalService;
import cn.zut.dao.entity.ProposalEntity;
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
public class ProposalController {

    @Resource
    private ProposalService proposalService;

    /**
     * 保存建议
     */
    @RequestMapping("save")
    public String saveProposal(ProposalEntity proposalEntity, HttpServletRequest request) {
        proposalService.saveProposal(proposalEntity);
        request.setAttribute("proposalEntity", "意见提交成功！");
        return "success";
    }

    /**
     * 查看所有建议
     */
    @ResponseBody
    @RequestMapping("findAll")
    public Map<String, Object> findAll() {
        List<ProposalEntity> list = proposalService.findAll();
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
    public ProposalEntity search(int id) {
        return proposalService.search(id);
    }
}
