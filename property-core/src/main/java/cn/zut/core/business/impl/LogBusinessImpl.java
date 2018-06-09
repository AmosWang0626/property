package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.EnterpriseBusiness;
import cn.zut.core.business.LogBusiness;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.entity.ManageLogEntity;
import cn.zut.dao.persistence.ManageEnterpriseMapper;
import cn.zut.dao.persistence.ManageLogMapper;
import cn.zut.facade.request.EnterpriseInfoRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("logBusiness")
public class LogBusinessImpl implements LogBusiness {

    @Resource
    private ManageLogMapper manageLogMapper;

    @Override
    public SimplePageResult<ManageLogEntity> pageMemberByModel(PageModel<ManageLogEntity> pageModel) {
        List<ManageLogEntity> applyEntities = manageLogMapper.selectListPageByExample(pageModel);
        int memberCount = manageLogMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<ManageLogEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(memberCount);
        pageResult.setRows(applyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }
}
