package cn.zut.core.service;

import cn.zut.dao.entity.ManageEnterpriseEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface ManageEnterpriseService {
    boolean addEnterprise(ManageEnterpriseEntity manageEnterpriseEntity);

    List<ManageEnterpriseEntity> enterpriseList();

    ManageEnterpriseEntity searchEnterprise(Long id);

    boolean rentEnterprise(ManageEnterpriseEntity businessCarSetEntity);
}
