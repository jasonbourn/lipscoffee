package com.lips.dao.lipsAdmin.pojo;

public class SysRole {
    /** 角色id */
    private Long id;

    /** 角色名 */
    private String role_name;

    /** 医院id */
    private Long hospital_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name == null ? null : role_name.trim();
    }

    public Long getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }
}