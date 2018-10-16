package com.alahr.springboot.system.mapper;

import com.alahr.springboot.system.dto.SysUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysUserMapper {

    @Select("select password from sys_user where user_name = #{userName}")
    String getPasswordByUsername(@Param("userName") String userName);

    @Select("select * from sys_user")
    List<SysUserDto> findAll();
}
