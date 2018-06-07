package cn.zut.core.service;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.GenericResponse;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.dao.entity.BusinessServiceEntity;

/**
 * @author LiuBowen
 */
public interface BusinessService {
    /**
     * 添加申请服务
     */
    GenericResponse addService(BusinessServiceEntity businessServiceEntity);

    /**
     * 查看所有服务
     */
    SimplePageResult<BusinessServiceEntity> serviceList(PageModel<BusinessServiceEntity> pageModel);

    /**
     * 同意服务
     */
    boolean agreeService(int serviceId);

    /**
     * 不同意服务操作
     */
    boolean disAgreeService(BusinessServiceEntity businessServiceEntity);

    boolean finService(BusinessServiceEntity businessServiceEntity);
}
