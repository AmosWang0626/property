package cn.zut.common.generic;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * PROJECT: property
 *
 * @author DaoYuanWang
 * @date 2018/4/14
 */
@Data
public class SimplePageResult<E> implements Serializable {
    private static final long serialVersionUID = 5248311773546420443L;

    /**
     * 当前是第几页
     */
    private int page;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 总记录数
     */
    private int total;
    /**
     * 对象列表
     */
    private List<E> rows;
}
