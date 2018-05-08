package cn.zut.common.redis;

import com.alibaba.fastjson.JSON;

/**
 * Redis 组件
 *
 * @author DaoyuanWang
 */
public class RedisComponent {

    private RedisContainer redisContainer;

    /**
     * 设置默认Redis数据库
     */
    public static final int PROPERTY_DB_INDEX = 10;

    public RedisContainer getRedisContainer() {
        return redisContainer;
    }

    public void setRedisContainer(RedisContainer redisContainer) {
        this.redisContainer = redisContainer;
    }

    /**
     * 保存参数信息
     *
     * @param key   KEY
     * @param value VALUE
     * @param time  缓存时间
     */
    public void save(String key, Object value, Integer time) {
        String valStr;
        if (value instanceof String) {
            valStr = (String) value;
        } else {
            valStr = JSON.toJSONString(value);
        }
        redisContainer.addString(key, valStr, time);
    }

    /**
     * 保存参数信息
     *
     * @param key   key
     * @param value value
     */
    public void save(String key, Object value) {
        String valStr;
        if (value instanceof String) {
            valStr = (String) value;
        } else {
            valStr = JSON.toJSONString(value);
        }
        redisContainer.addString(key, valStr);
    }

    /**
     * 获取参数信息
     *
     * @param key key
     * @return String
     */
    public String get(String key) {
        return redisContainer.getString(key);
    }

    /**
     * 获取参数信息重载方法
     *
     * @param key KEY
     * @return String
     */
    public synchronized String get(String key, Integer dbIndex) {
        int originalIndex = redisContainer.getDbIndex();
        if (dbIndex != null) {
            redisContainer.setDbIndex(dbIndex);
        }
        String result = redisContainer.getString(key);
        redisContainer.setDbIndex(originalIndex);
        return result;
    }

    /**
     * 给key设置新的过期时间
     *
     * @param key  key
     * @param time time
     */
    public void setNewTime(String key, Integer time) {
        redisContainer.setNewTime(key, time);
    }

    /**
     * 删除KEY对应的内容重载方法
     *
     * @param key KEY
     */
    public void del(String key) {
        redisContainer.delKey(key);
    }
}
