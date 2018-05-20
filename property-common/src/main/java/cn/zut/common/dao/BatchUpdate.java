package cn.zut.common.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * 批量更新对象 T
 *
 * @param <T>
 */
public interface BatchUpdate<T> {

    Integer batchUpdate(@Param("list") Collection<T> list);
}
