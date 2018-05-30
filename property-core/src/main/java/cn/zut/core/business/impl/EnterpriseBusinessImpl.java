package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.EnterpriseBusiness;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.facade.request.EnterpriseInfoRequest;
import org.springframework.stereotype.Component;

@Component("enterpriseBusiness")
public class EnterpriseBusinessImpl implements EnterpriseBusiness {
    @Override
    public SimplePageResult<ManageEnterpriseEntity> pageMemberByModel(PageModel<ManageEnterpriseEntity> pageModel) {
        return null;
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
