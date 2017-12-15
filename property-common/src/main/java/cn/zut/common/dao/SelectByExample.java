package cn.zut.common.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 根据搜索对象查返回单一结果集
 */
public interface SelectByExample<T, S> {

    T selectByExample(@Param("search") S search);
}
