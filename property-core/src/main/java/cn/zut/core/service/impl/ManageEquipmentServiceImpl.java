package cn.zut.core.service.impl;

import cn.zut.core.service.ManageEquipmentService;
import cn.zut.dao.entity.ManageEquipmentEntity;
import cn.zut.dao.persistence.ManageEquipmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YangShangYu
 */
@Service("manageEquipmentService")
public class ManageEquipmentServiceImpl implements ManageEquipmentService {

    @Resource
    private ManageEquipmentMapper manageEquipmentMapper;

    @Override
    public boolean addEquipment(ManageEquipmentEntity manageEquipmentEntity) {
        return manageEquipmentMapper.insert(manageEquipmentEntity) > 0;
    }

    @Override
    public List<ManageEquipmentEntity> EquipmentList() {
        return null;
    }

    @Override
    public ManageEquipmentEntity searchEquipment(Long id) {
        return null;
    }

    @Override
    public boolean rentEquipment(ManageEquipmentEntity businessEquipmentEntity) {
        return false;
    }
}
