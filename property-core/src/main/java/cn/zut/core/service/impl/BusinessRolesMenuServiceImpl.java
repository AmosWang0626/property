package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessRolesMenuService;
import cn.zut.dao.entity.BusinessMenuRolesEntity;
import cn.zut.dao.persistence.BusinessMenuRolesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessRolesMenuService")
public class BusinessRolesMenuServiceImpl implements BusinessRolesMenuService {
    @Resource
    private BusinessMenuRolesMapper businessMenuRolesMapper;

    @Override
    public List<Integer> getMenusIdList(int roleId) {
        List<BusinessMenuRolesEntity> menuRoleEntities = businessMenuRolesMapper.selectById(roleId);
        List<Integer> menus=new ArrayList<>();
        for (BusinessMenuRolesEntity m: menuRoleEntities) {
            menus.add(m.getMenuId());
        }
        return menus;
    }
}
