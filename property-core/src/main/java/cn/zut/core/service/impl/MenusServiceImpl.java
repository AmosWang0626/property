package cn.zut.core.service.impl;

import cn.zut.core.service.MenusService;
import cn.zut.dao.entity.MenusEntity;
import cn.zut.dao.persistence.MenusMapper;
import cn.zut.dao.search.BusinessMenusSearch;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service
public class MenusServiceImpl implements MenusService {

    @Resource
    private MenusMapper menusMapper;

    @Override
    public List<MenusEntity> getAllMenus(List<Integer> menus) {
        BusinessMenusSearch businessMenusSearch = new BusinessMenusSearch();
        businessMenusSearch.setMenuIds(menus);
        return menusMapper.selectListByExample(businessMenusSearch);
    }
}
