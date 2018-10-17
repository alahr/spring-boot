package com.alahr.springboot.module.system.service.impl;

import com.alahr.springboot.module.system.dto.SysResourceDto;
import com.alahr.springboot.module.system.mapper.SysResourceMapper;
import com.alahr.springboot.module.system.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResourceDto> findResourcesBySysRoleId(BigInteger sysRoleId) {
        return sysResourceMapper.findResourcesBySysRoleId(sysRoleId);
    }
}
