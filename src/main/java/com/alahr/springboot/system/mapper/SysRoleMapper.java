package com.alahr.springboot.system.mapper;

import com.alahr.springboot.system.dto.SysRoleDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface SysRoleMapper {
    @Select("select r.* from sys_role r left join sys_user_role ur on ur.sys_role_id = r.id where ur.sys_user_id=#{sysUserId}")
    List<SysRoleDto> findRolesBySysUserId(@Param("sysUserId") BigInteger sysUserId);
}
