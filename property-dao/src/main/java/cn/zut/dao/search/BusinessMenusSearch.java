package cn.zut.dao.search;

import lombok.Data;

import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 菜单查询类
 *
 * @author DaoYuanWang
 * @date 2018/5/7
 */
@Data
public class BusinessMenusSearch {
    /**
     * 多个id
     */
    private List<Integer> menuIds;

    private String menuName;

    private String menuUrl;

    private Integer fatherId;
}
