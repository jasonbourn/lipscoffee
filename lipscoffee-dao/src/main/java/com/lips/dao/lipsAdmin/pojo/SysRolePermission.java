package com.lips.dao.lipsAdmin.pojo;

public class SysRolePermission {
    /** 角色id */
    private Long role_id;

    /** 资源id */
    private Long permission_id;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Long permission_id) {
        this.permission_id = permission_id;
    }
}