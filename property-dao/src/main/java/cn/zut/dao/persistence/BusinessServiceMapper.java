package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessServiceEntity;

public interface BusinessServiceMapper extends
        Insert<BusinessServiceEntity>,
        Update<BusinessServiceEntity>,
        DeleteById<Integer>,
        SelectById<BusinessServiceEntity, Integer>,
        SelectByExample<BusinessServiceEntity, BusinessServiceEntity>,
        SelectListByExample<BusinessServiceEntity, BusinessServiceEntity>,
        SelectCountByExample<BusinessServiceEntity>,
        SelectListPageByExample<BusinessServiceEntity, BusinessServiceEntity> {
}