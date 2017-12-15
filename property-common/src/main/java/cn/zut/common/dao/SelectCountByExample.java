package cn.zut.common.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 满足查询条件对象数量
 */
public interface SelectCountByExample<S> {

    Long selectCountByExample(@Param("search") S search);
}
