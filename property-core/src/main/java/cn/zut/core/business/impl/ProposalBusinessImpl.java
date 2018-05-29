package cn.zut.core.business.impl;

import cn.zut.common.dao.PageModel;
import cn.zut.common.generic.SimplePageResult;
import cn.zut.core.business.ProposalBusiness;
import cn.zut.dao.entity.BusinessProposalEntity;
import cn.zut.dao.persistence.BusinessProposalMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * @author Liubowen
 */
@Component("proposalBusiness")
public class ProposalBusinessImpl implements ProposalBusiness {

    @Resource
    private BusinessProposalMapper businessProposalMapper;


    @Transactional(rollbackFor = Exception.class)

    @Override
    public SimplePageResult<BusinessProposalEntity> pageMemberByModel(PageModel<BusinessProposalEntity> pageModel) {
        List<BusinessProposalEntity> applyEntities = businessProposalMapper.selectListPageByExample(pageModel);
        int carCount = businessProposalMapper.selectCountByExample(pageModel.getSearch());
        SimplePageResult<BusinessProposalEntity> pageResult = new SimplePageResult<>();
        // 总记录数量 || 记录数据列表 || 页码 || 记录数量
        pageResult.setTotal(carCount);
        pageResult.setRows(applyEntities);
        pageResult.setPage(pageModel.getPage());
        pageResult.setSize(pageModel.getRows());
        return pageResult;
    }

}
