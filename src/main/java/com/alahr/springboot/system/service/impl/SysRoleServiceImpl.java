package com.alahr.springboot.system.service.impl;

import com.alahr.springboot.system.dto.SysRoleDto;
import com.alahr.springboot.system.dto.SysUserDto;
import com.alahr.springboot.system.mapper.SysRoleMapper;
import com.alahr.springboot.system.mapper.SysUserMapper;
import com.alahr.springboot.system.service.SysRoleService;
import com.alahr.springboot.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRoleDto> findRolesBySysUserId(BigInteger sysUserId) {
        return sysRoleMapper.findRolesBySysUserId(sysUserId);
    }
}
