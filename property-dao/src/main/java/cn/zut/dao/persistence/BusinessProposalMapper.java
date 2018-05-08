package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.BusinessProposalEntity;

public interface BusinessProposalMapper extends
        Insert<BusinessProposalEntity>,
        Update<BusinessProposalEntity>,
        DeleteById<Integer>,
        SelectById<BusinessProposalEntity, Integer>,
        SelectByExample<BusinessProposalEntity, BusinessProposalEntity>,
        SelectListByExample<BusinessProposalEntity, BusinessProposalEntity>,
        SelectCountByExample<BusinessProposalEntity>,
        SelectListPageByExample<BusinessProposalEntity, BusinessProposalEntity> {
}