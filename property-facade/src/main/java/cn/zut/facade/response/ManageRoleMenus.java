package cn.zut.facade.response;

import lombok.Data;

import java.io.Serializable;

/**
 * PROJECT: property
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/5/29
 */
@Data
public class ManageRoleMenus implements Serializable {

    private static final long serialVersionUID = 4253288808105320320L;

    /**
     * 菜单id
     */
    private Integer key;
    /**
     * 菜单释义
     */
    private String label;

    public ManageRoleMenus(Integer key, String label) {
        this.key = key;
        this.label = label;
    }
}
