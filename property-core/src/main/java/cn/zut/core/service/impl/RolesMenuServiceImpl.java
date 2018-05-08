package cn.zut.core.service.impl;

import cn.zut.core.service.RolesMenuService;
import cn.zut.dao.entity.MenuRolesEntity;
import cn.zut.dao.persistence.MenuRolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service
public class RolesMenuServiceImpl implements RolesMenuService {
    @Resource
    private MenuRolesMapper menuRolesMapper;

    @Override
    public List<Integer> getMenusIdList(int roleId) {
        List<MenuRolesEntity> menuRoleEntities =menuRolesMapper.selectById(roleId);
        List<Integer> menus=new ArrayList<>();
        for (MenuRolesEntity m: menuRoleEntities) {
            menus.add(m.getMenuId());
        }
        return menus;
    }
}
