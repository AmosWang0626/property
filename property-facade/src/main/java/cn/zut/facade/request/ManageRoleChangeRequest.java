package cn.zut.facade.request;

import lombok.Data;

import java.util.List;

/**
 * PROJECT: property
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/5/29
 */
@Data
public class ManageRoleChangeRequest {

    /**
     * 授权/取消授权
     * right/left
     */
    private String direction;
    /**
     * 角色 id
     */
    private Integer rolesId;
    /**
     * 菜单 id
     */
    private List<Integer> menuIds;
}
