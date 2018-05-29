package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.HouseBusiness;
import cn.zut.dao.entity.BusinessHouseRentEntity;
import cn.zut.dao.persistence.BusinessHouseRentMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liubowen
 */
@Component("houseBusiness")
public class HouseBusinessImpl implements HouseBusiness {

    @Resource
    private BusinessHouseRentMapper businessHouseRentMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SimplePageResult<BusinessHouseRentEntity> pageMemberByModel(PageModel<BusinessHouseRentEntity> pageModel) {
        List<BusinessHouseRentEntity> applyEntities = businessHouseRentMapper.selectListPageByExample(pageModel);
        int carCount = businessHouseRentMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<BusinessHouseRentEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(carCount);
        pageResult.setRows(applyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }

}
