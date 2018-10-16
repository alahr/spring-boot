package com.alahr.springboot.module.system.service.impl;

import com.alahr.springboot.module.system.dto.SysRoleDto;
import com.alahr.springboot.module.system.mapper.SysRoleMapper;
import com.alahr.springboot.module.system.service.SysRoleService;
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
