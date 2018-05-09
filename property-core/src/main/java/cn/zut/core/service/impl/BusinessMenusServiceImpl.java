package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessMenusService;
import cn.zut.dao.entity.BusinessMenuRolesEntity;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.entity.BusinessRolesEntity;
import cn.zut.dao.persistence.BusinessMenuRolesMapper;
import cn.zut.dao.persistence.BusinessMenusMapper;
import cn.zut.dao.persistence.BusinessRolesMapper;
import cn.zut.dao.search.BusinessMenusSearch;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessMenusService")
public class BusinessMenusServiceImpl implements BusinessMenusService {

    @Resource
    private BusinessRolesMapper businessRolesMapper;
    @Resource
    private BusinessMenusMapper businessMenusMapper;
    @Resource
    private BusinessMenuRolesMapper businessMenuRolesMapper;

    @Override
    public List<BusinessMenusEntity> getAllMenus(Integer rolesId) {
        BusinessRolesEntity businessRolesEntity = businessRolesMapper.selectById(rolesId);
        if (businessRolesEntity == null) {
            return null;
        }

        List<Integer> menusIdList = getMenusIdList(rolesId);

        BusinessMenusSearch businessMenusSearch = new BusinessMenusSearch();
        businessMenusSearch.setMenuIds(menusIdList);
        return businessMenusMapper.selectListByExample(businessMenusSearch);
    }

    /**
     * 根据用户角色获取对应的菜单id
     *
     * @param rolesId 角色id
     * @return 角色支持的菜单id
     */
    private List<Integer> getMenusIdList(Integer rolesId) {
        List<BusinessMenuRolesEntity> menuRoleEntities = businessMenuRolesMapper.selectById(rolesId);
        List<Integer> menusIdList = new ArrayList<>();
        for (BusinessMenuRolesEntity menuRolesEntity : menuRoleEntities) {
            menusIdList.add(menuRolesEntity.getMenuId());
        }

        return menusIdList;
    }
}
