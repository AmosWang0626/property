package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessCarSetEntity;

public interface BusinessCarSetMapper extends
        Insert<BusinessCarSetEntity>,
        Update<BusinessCarSetEntity>,
        DeleteById<Integer>,
        SelectById<BusinessCarSetEntity, Integer>,
        SelectByExample<BusinessCarSetEntity, BusinessCarSetEntity>,
        SelectListByExample<BusinessCarSetEntity, BusinessCarSetEntity>,
        SelectCountByExample<BusinessCarSetEntity>,
        SelectListPageByExample<BusinessCarSetEntity, BusinessCarSetEntity> {
}