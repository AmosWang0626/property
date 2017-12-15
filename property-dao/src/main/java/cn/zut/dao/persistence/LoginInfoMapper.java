package cn.zut.dao.persistence;


import cn.zut.common.dao.Insert;
import cn.zut.common.dao.SelectById;
import cn.zut.common.dao.Update;
import cn.zut.dao.entity.LoginInfoEntity;

/**
 * DATE: 2017/11/21
 * PROJECT: catherine
 *
 * @author DaoyuanWang
 */
public interface LoginInfoMapper extends Insert<LoginInfoEntity>, Update<LoginInfoEntity>,
        SelectById<LoginInfoEntity, Long> {

}
