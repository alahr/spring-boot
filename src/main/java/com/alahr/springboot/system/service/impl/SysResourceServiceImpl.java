package com.alahr.springboot.system.service.impl;

import com.alahr.springboot.system.dto.SysResourceDto;
import com.alahr.springboot.system.mapper.SysRoleMapper;
import com.alahr.springboot.system.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysResourceDto> findResourcesBySysRoleId(BigInteger sysRoleId) {
        return null;
    }
}