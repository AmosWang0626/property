package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.CarBusiness;
import cn.zut.dao.entity.BusinessCarSetEntity;
import cn.zut.dao.persistence.BusinessCarSetMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * @author Liubowen
 */
@Component("carBusiness")
public class CarBusinessImpl implements CarBusiness {

    @Resource
    private BusinessCarSetMapper businessCarSetMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public SimplePageResult<BusinessCarSetEntity> pageMemberByModel(PageModel<BusinessCarSetEntity> pageModel) {
        List<BusinessCarSetEntity> applyEntities = businessCarSetMapper.selectListPageByExample(pageModel);
        int carCount = businessCarSetMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<BusinessCarSetEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(carCount);
        pageResult.setRows(applyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }

}
