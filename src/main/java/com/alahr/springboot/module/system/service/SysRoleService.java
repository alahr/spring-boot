package com.alahr.springboot.module.system.service;

import com.alahr.springboot.module.system.dto.SysRoleDto;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface SysRoleService {
    List<SysRoleDto> findRolesBySysUserId(@Param("sysUserId") BigInteger sysUserId);
}
