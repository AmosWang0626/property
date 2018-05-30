package cn.zut.core.service.impl;

import cn.zut.core.service.ManageEnterpriseService;
import cn.zut.dao.entity.ManageEnterpriseEntity;
import cn.zut.dao.persistence.ManageEnterpriseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YangShangYu
 */
@Service("manageEnterpriseService")
public class ManageEnterpriseServiceImpl implements ManageEnterpriseService {

    @Resource
    private ManageEnterpriseMapper manageEnterpriseMapper;

    /**
     * 添加车辆进入信息
     */
    @Override
    public boolean addEnterprise(ManageEnterpriseEntity manageEnterpriseEntity) {
        return manageEnterpriseMapper.insert(manageEnterpriseEntity) > 0;
    }

    /**
     * 查看所有的车辆信息
     */
    @Override
    public List<ManageEnterpriseEntity> enterpriseList() {
        return manageEnterpriseMapper.selectListByExample(null);
    }

  /*  @Override
    public ManageEnterpriseEntity searchEnterprise(int id) {
        return null;
    }

    @Override
    public boolean rentEnterprise(ManageEnterpriseEntity businessCarSetEntity) {
        return false;
    }*/

    /**
     * 获取车辆信息
     */
    @Override
    public ManageEnterpriseEntity searchEnterprise(Long id) {
        return manageEnterpriseMapper.selectById(id);
    }

    @Override
    public boolean rentEnterprise(ManageEnterpriseEntity manageEnterpriseEntity) {
        int x = manageEnterpriseMapper.update(manageEnterpriseEntity);
        return x > 0;
    }
}
