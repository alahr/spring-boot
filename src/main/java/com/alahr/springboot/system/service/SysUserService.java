package com.alahr.springboot.system.service;

import com.alahr.springboot.system.dto.SysUserDto;

import java.util.List;

public interface SysUserService {
    String getPasswordByUsername(String username);

    List<SysUserDto> findAll();
}
