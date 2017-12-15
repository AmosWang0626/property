package cn.zut.common.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * 批量插入对象 T
 *
 * @param <T>
 */
public interface BatchInsert<T> {

    Integer batchInsert(@Param("list") Collection<T> list);
}
