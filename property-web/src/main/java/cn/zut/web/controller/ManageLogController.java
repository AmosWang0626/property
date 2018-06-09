package cn.zut.web.controller;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.core.business.LogBusiness;
import cn.zut.dao.entity.ManageLogEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("log")
@RestController
public class ManageLogController {

    @Resource
    private LogBusiness logBusiness;

    @GetMapping("page")
    public GenericResponse pageApply(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return GenericResponse.SUCCESS;
        }
        PageModel<ManageLogEntity> pageModel = new PageModel<>();
        pageModel.setPage(page);
        pageModel.setRows(size);
        return new GenericResponse<>(logBusiness.pageMemberByModel(pageModel));
    }
}
