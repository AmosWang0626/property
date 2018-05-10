package cn.zut.facade.response;

import lombok.Data;

/**
 * PROJECT: property2
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/5/9
 */
@Data
public class MenuSecondLevelVO {

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
