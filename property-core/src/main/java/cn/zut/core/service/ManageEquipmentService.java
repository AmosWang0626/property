package cn.zut.core.service;

import cn.zut.dao.entity.ManageEquipmentEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface ManageEquipmentService {
    boolean addEquipment(ManageEquipmentEntity manageEquipmentEntity);

    List<ManageEquipmentEntity> EquipmentList();

    ManageEquipmentEntity searchEquipment(Long id);

    boolean rentEquipment(ManageEquipmentEntity businessEquipmentEntity);
}
