package com.alahr.springboot.module.system.service;

import com.alahr.springboot.module.system.dto.SysResourceDto;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface SysResourceService {
    List<SysResourceDto> findResourcesBySysRoleId(@Param("sysRoleId") BigInteger sysRoleId);
}
