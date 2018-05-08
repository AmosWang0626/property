package cn.zut.common.dao;

import java.io.Serializable;

/**
 * 删除
 */
public interface DeleteById<S extends Serializable> {

    int deleteById(S id);
}
