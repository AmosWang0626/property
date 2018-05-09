package cn.zut.common.api;

/**
 * PROJECT: property
 * DATE: 2017/11/30
 *
 * @param <K> key类型
 * @param <V> Value值类型
 * @author DaoYuanWang
 */
public interface Mapping<K, V> {
    /**
     * 获取key
     *
     * @return key
     */
    K getKey();

    /**
     * 获取Value
     *
     * @return value
     */
    V getValue();
}
