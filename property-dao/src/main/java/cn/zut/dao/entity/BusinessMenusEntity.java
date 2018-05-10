package cn.zut.dao.entity;

import lombok.Data;

/**
 * @author LiuBowen
 */
@Data
public class BusinessMenusEntity {

    /**
     * 菜单编号
     */
    private Integer menuId;
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
     * 菜单优先级
     */
    private Integer priority;
    /**
     * 菜单图标
     */
    private String menuIcon;
}