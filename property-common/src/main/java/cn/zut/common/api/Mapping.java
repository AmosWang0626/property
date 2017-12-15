package cn.zut.common.api;

/**
 * PROJECT: catherine
 * DATE: 2017/11/30
 *
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
