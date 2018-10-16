package com.alahr.springboot.system.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class SysResourceDto implements Serializable {
    private static final long serialVersionUID = 4L;

    private BigInteger id;
    private String resourceName;
    private String resourceAlias;
    private String description;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceAlias() {
        return resourceAlias;
    }

    public void setResourceAlias(String resourceAlias) {
        this.resourceAlias = resourceAlias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
