package com.alahr.springboot.system.mapper;

import com.alahr.springboot.system.dto.SysResourceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface SysResourceMapper {
    @Select("select r.* from sys_resource r left join sys_role_resource rr on rr.sys_resource_id = r.id where rr.sys_role_id=#{sysRoleId}")
    List<SysResourceDto> findResourcesBySysRoleId(@Param("sysRoleId") BigInteger sysRoleId);
}
