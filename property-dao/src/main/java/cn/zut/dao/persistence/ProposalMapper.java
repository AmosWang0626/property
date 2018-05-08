package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.ProposalEntity;

public interface ProposalMapper extends
        Insert<ProposalEntity>,
        Update<ProposalEntity>,
        DeleteById<Integer>,
        SelectById<ProposalEntity, Integer>,
        SelectByExample<ProposalEntity, ProposalEntity>,
        SelectListByExample<ProposalEntity, ProposalEntity>,
        SelectCountByExample<ProposalEntity>,
        SelectListPageByExample<ProposalEntity, ProposalEntity> {
}