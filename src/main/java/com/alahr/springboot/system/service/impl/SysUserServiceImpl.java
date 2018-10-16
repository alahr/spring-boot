package com.alahr.springboot.system.service.impl;

import com.alahr.springboot.system.mapper.SysUserMapper;
import com.alahr.springboot.system.dto.SysUserDto;
import com.alahr.springboot.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public String getPasswordByUsername(String username) {
        return sysUserMapper.getPasswordByUsername(username);
    }

    @Override
    public List<SysUserDto> findAll() {
        return sysUserMapper.findAll();
    }
}
