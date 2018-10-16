package com.alahr.springboot.module.system.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class SysRoleDto implements Serializable {
    private static final long serialVersionUID = 3L;

    private BigInteger id;
    private String roleName;
    private String roleAlias;
    private String description;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleAlias() {
        return roleAlias;
    }

    public void setRoleAlias(String roleAlias) {
        this.roleAlias = roleAlias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
