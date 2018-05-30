package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.entity.ManageEquipmentEntity;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author yangshangyu
 */
public interface ManageEquipmentMapper extends Insert<ManageEquipmentEntity>, Update<ManageEquipmentEntity>,
        SelectById<ManageEquipmentEntity, Long>, SelectByExample<ManageEquipmentEntity, ManageEquipmentEntity>,
        SelectListByExample<ManageEquipmentEntity, ManageEquipmentEntity>,
        SelectCountByExample<ManageEquipmentEntity>, SelectListPageByExample<ManageEquipmentEntity, ManageEquipmentEntity> {
}
