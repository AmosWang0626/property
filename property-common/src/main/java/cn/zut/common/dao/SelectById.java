package cn.zut.common.dao;

import java.io.Serializable;

/**
 * 根据主键ID查询对象
 */
public interface SelectById<T, S extends Serializable> {

    T selectById(S id);
}
