package cn.zut.dao.entity;

public class BusinessMenuRolesEntity {

    private Integer rolesId;

    private Integer menuId;

    public BusinessMenuRolesEntity(Integer rolesId, Integer menuId) {
        this.rolesId = rolesId;
        this.menuId = menuId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}