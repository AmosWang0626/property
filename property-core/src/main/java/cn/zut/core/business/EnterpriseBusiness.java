package cn.zut.core.business;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.facade.request.EnterpriseInfoRequest;

public interface EnterpriseBusiness {

    SimplePageResult<ManageEnterpriseEntity> pageMemberByModel(PageModel<ManageEnterpriseEntity> pageModel);

    /**
     * 修改企业信息
     *
     * @param enterpriseInfoRequest UserInfoRequest
     * @return GenericResponse
     */
    GenericResponse enterpriseInfo(EnterpriseInfoRequest enterpriseInfoRequest);

    /**
     * 删除企业
     *
     * @param enterpriseInfoRequest UserInfoRequest
     * @return GenericResponse
     */
    GenericResponse deleteEnterprise(EnterpriseInfoRequest enterpriseInfoRequest);
}
