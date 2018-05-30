package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.ProposalBusiness;
import cn.zut.core.service.BusinessProposalService;
import cn.zut.dao.entity.BusinessProposalEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiuBowen
 */
@RestController
@RequestMapping("proposal")
public class BusinessProposalController {

    @Resource
    private BusinessProposalService businessProposalService;
    @Resource
    private ProposalBusiness proposalBusiness;

    /**
     * 保存建议
     */
    @RequestMapping("save")
    public GenericResponse saveProposal(@RequestBody BusinessProposalEntity businessProposalEntity, HttpServletRequest request) {
        businessProposalService.saveProposal(businessProposalEntity);
        request.setAttribute("businessProposalEntity", "意见提交成功！");
        return GenericResponse.SUCCESS;
    }

    /**
     * 查看所有建议
     */
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


    //得到意见建议
    @GetMapping("pageproposal")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<BusinessProposalEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(proposalBusiness.pageMemberByModel(pageModel));
    }
}
