package cn.zut.common.api;

import java.io.Serializable;

/**
 * 方便前端显示下拉列表
 *
 * @author DaoyuanWang
 */
public class ComboVO<K, V> implements Mapping<K, V>, Serializable {

    private static final long serialVersionUID = -4360105044701935377L;

    private K key;
    private V value;

    public ComboVO() {
    }

    public ComboVO(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public ComboVO(Mapping<K, V> mapping) {
        this.key = mapping.getKey();
        this.value = mapping.getValue();
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
