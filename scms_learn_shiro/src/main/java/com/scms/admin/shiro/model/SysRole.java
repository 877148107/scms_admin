package com.scms.admin.shiro.model;

import java.io.Serializable;
import java.util.Set;

/**
 * @ClassName: SysRole
 * =================================================
 * @Description: 角色
 * =================================================
 * CreateInfo:
 * @Author: William.Wangmy
 * @Email: wangmingyong2018@163.com
 * @CreateDate: 2020/1/19 15:50
 * @Version: V1.0
 */
public class SysRole implements Serializable {

    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<SysPermission> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<SysPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}