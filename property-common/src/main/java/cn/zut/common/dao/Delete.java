package cn.zut.common.dao;

import java.io.Serializable;

/**
 * 删除
 */
public interface Delete<S extends Serializable> {

    void delete(S id);
}
