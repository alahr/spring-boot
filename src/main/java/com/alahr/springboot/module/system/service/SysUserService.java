package com.alahr.springboot.module.system.service;

import com.alahr.springboot.module.system.dto.SysUserDto;

import java.util.List;

public interface SysUserService {
    String getPasswordByUsername(String username);

    List<SysUserDto> findAll();
}
