package com.alahr.springboot.system.service;

import com.alahr.springboot.system.dto.SysRoleDto;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface SysRoleService {
    List<SysRoleDto> findRolesBySysUserId(@Param("sysUserId") BigInteger sysUserId);
}
