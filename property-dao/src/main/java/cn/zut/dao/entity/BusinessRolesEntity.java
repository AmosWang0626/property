package cn.zut.dao.entity;

import lombok.Data;

/**
 * @author LiuBowen
 */
@Data
public class BusinessRolesEntity {

    /**
     * 角色id
     */
    private Integer rolesId;
    /**
     * 角色名称
     */
    private String rolesName;
    /**
     * 角色描述
     */
    private String rolesDesc;

}