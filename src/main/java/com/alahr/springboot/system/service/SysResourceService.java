package com.alahr.springboot.system.service;

import com.alahr.springboot.system.dto.SysResourceDto;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface SysResourceService {
    List<SysResourceDto> findResourcesBySysRoleId(@Param("sysRoleId") BigInteger sysRoleId);
}
