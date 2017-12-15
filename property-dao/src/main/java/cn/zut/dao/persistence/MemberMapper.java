package cn.zut.dao.persistence;

import cn.zut.common.dao.Insert;
import cn.zut.common.dao.SelectByExample;
import cn.zut.common.dao.SelectById;
import cn.zut.common.dao.Update;
import cn.zut.dao.entity.MemberEntity;
import cn.zut.dao.search.MemberSearch;

/**
 * PROJECT: catherine
 * DATE: 2017/11/21
 *
 * @author DaoYuanWang
 */
public interface MemberMapper extends Insert<MemberEntity>, Update<MemberEntity>,
        SelectById<MemberEntity, Long>, SelectByExample<MemberEntity, MemberSearch> {
}
