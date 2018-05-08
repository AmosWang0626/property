package cn.zut.core.service.impl;

import cn.zut.core.service.BusinessProposalService;
import cn.zut.dao.entity.BusinessProposalEntity;
import cn.zut.dao.persistence.BusinessProposalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service("businessProposalService")
public class BusinessProposalServiceImpl implements BusinessProposalService {
    @Resource
    private BusinessProposalMapper businessProposalMapper;

    /**
     * 保存建议到数据库业务
     */
    @Override
    public boolean saveProposal(BusinessProposalEntity businessProposalEntity) {
        int x = businessProposalMapper.insert(businessProposalEntity);
        return x > 0;
    }

    /**
     * 返回所有建议
     */
    @Override
    public List<BusinessProposalEntity> findAll() {
        return businessProposalMapper.selectListByExample(null);
    }

    @Override
    public BusinessProposalEntity search(int id) {
        return businessProposalMapper.selectById(id);
    }
}
