package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.EnterpriseBusiness;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.persistence.ManageEnterpriseMapper;
import cn.zut.facade.request.EnterpriseInfoRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("enterpriseBusiness")
public class EnterpriseBusinessImpl implements EnterpriseBusiness {

    @Resource
    private ManageEnterpriseMapper manageEnterpriseMapper;

    @Override
    public SimplePageResult<ManageEnterpriseEntity> pageMemberByModel(PageModel<ManageEnterpriseEntity> pageModel) {
        List<ManageEnterpriseEntity> applyEntities = manageEnterpriseMapper.selectListPageByExample(pageModel);
        int memberCount = manageEnterpriseMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<ManageEnterpriseEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(memberCount);
        pageResult.setRows(applyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }

    @Override
    public GenericResponse enterpriseInfo(EnterpriseInfoRequest enterpriseInfoRequest) {
        return null;
    }

    @Override
    public GenericResponse deleteEnterprise(EnterpriseInfoRequest enterpriseInfoRequest) {
        return null;
    }
}
