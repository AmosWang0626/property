package cn.zut.core.service.impl;

import cn.zut.core.service.ProposalService;
import cn.zut.dao.entity.ProposalEntity;
import cn.zut.dao.persistence.ProposalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiuBowen
 */
@Service
public class ProposalServiceImpl implements ProposalService {
    @Resource
    private ProposalMapper proposalMapper;

    /**
     * 保存建议到数据库业务
     */
    @Override
    public boolean saveProposal(ProposalEntity proposalEntity) {
        int x = proposalMapper.insert(proposalEntity);
        return x > 0;
    }

    /**
     * 返回所有建议
     */
    @Override
    public List<ProposalEntity> findAll() {
        return proposalMapper.selectListByExample(null);
    }

    @Override
    public ProposalEntity search(int id) {
        return proposalMapper.selectById(id);
    }
}
