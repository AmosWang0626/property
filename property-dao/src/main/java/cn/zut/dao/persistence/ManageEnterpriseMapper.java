package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.ManageEnterpriseEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author yangshangyu
 */
public interface ManageEnterpriseMapper extends Insert<ManageEnterpriseEntity>, Update<ManageEnterpriseEntity>,
        SelectById<ManageEnterpriseEntity, Long>, SelectByExample<ManageEnterpriseEntity, ManageEnterpriseEntity>,
        SelectListByExample<ManageEnterpriseEntity, ManageEnterpriseEntity>,
        SelectCountByExample<ManageEnterpriseEntity>, SelectListPageByExample<ManageEnterpriseEntity, ManageEnterpriseEntity> {
}
