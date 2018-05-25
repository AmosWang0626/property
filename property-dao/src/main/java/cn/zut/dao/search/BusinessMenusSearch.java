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
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单URL
     */
    private String menuUrl;
    /**
     * 父级菜单id
     */
    private Integer fatherId;
    /**
     * 父菜单 id 不为 0
     */
    private Boolean haveFatherId;
}
