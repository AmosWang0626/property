package cn.zut.core.service;

import cn.zut.dao.entity.BusinessProposalEntity;

import java.util.List;

/**
 * @author LiuBowen
 */
public interface BusinessProposalService {
    /**
     *  保存数据库业务
     */
    boolean saveProposal(BusinessProposalEntity businessProposalEntity);

    /**
     *  返回所有建议
     */
    List<BusinessProposalEntity> findAll();

    /**
     * 返回指定建议
     */
    BusinessProposalEntity search(int id);
}
