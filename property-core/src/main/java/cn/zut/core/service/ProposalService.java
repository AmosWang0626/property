package cn.zut.core.service;

import cn.zut.dao.entity.ProposalEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface ProposalService {
    /**
     *  保存数据库业务
     */
    boolean saveProposal(ProposalEntity proposalEntity);

    /**
     *  返回所有建议
     */
    List<ProposalEntity> findAll();

    /**
     * 返回指定建议
     */
    ProposalEntity search(int id);
}
