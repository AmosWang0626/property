package cn.zut.dao.persistence;

import cn.zut.common.dao.*;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.search.MemberSearch;

/**
 * PROJECT: property
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberMapper extends Insert<MemberEntity>, Update<MemberEntity>, DeleteById<Long>,
        SelectById<MemberEntity, Long>, SelectByExample<MemberEntity, MemberSearch>,
        SelectCountByExample<MemberSearch>, SelectListPageByExample<MemberEntity, MemberSearch> {
}
