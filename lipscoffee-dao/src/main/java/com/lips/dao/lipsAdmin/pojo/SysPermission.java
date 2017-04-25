package com.lips.dao.lipsAdmin.pojo;

public class SysPermission {
    /** 资源id */
    private Long id;

    /** 资源名称 */
    private String permission_name;

    /** 资源类型（菜单:1，按钮:2） */
    private Integer permission_type;

    /** 资源key(唯一值) */
    private String permission_key;

    /** 资源url */
    private String permission_url;

    /** 图标 */
    private String permission_icon;

    /** 权重 */
    private Integer weight;

    /** 是否显示（1:显示 0：不显示） */
    private Boolean sidebar;

    /** 备注 */
    private String remarks;

    /** 医院是否显示 0：不显示 1：显示 */
    private Boolean display;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name == null ? null : permission_name.trim();
    }

    public Integer getPermission_type() {
        return permission_type;
    }

    public void setPermission_type(Integer permission_type) {
        this.permission_type = permission_type;
    }

    public String getPermission_key() {
        return permission_key;
    }

    public void setPermission_key(String permission_key) {
        this.permission_key = permission_key == null ? null : permission_key.trim();
    }

    public String getPermission_url() {
        return permission_url;
    }

    public void setPermission_url(String permission_url) {
        this.permission_url = permission_url == null ? null : permission_url.trim();
    }

    public String getPermission_icon() {
        return permission_icon;
    }

    public void setPermission_icon(String permission_icon) {
        this.permission_icon = permission_icon == null ? null : permission_icon.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getSidebar() {
        return sidebar;
    }

    public void setSidebar(Boolean sidebar) {
        this.sidebar = sidebar;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }
}