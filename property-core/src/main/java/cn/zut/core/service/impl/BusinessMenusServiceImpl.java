package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessMenusService;
import cn.zut.dao.entity.BusinessMenusEntity;
import cn.zut.dao.persistence.BusinessMenusMapper;
import cn.zut.dao.search.BusinessMenusSearch;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessMenusService")
public class BusinessMenusServiceImpl implements BusinessMenusService {

    @Resource
    private BusinessMenusMapper businessMenusMapper;

    @Override
    public List<BusinessMenusEntity> getAllMenus(List<Integer> menus) {
        BusinessMenusSearch businessMenusSearch = new BusinessMenusSearch();
        businessMenusSearch.setMenuIds(menus);
        return businessMenusMapper.selectListByExample(businessMenusSearch);
    }
}
