package com.alahr.springboot.module.system;

import com.alahr.springboot.module.system.dto.SysResourceDto;
import com.alahr.springboot.module.system.mapper.SysResourceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SysUserTest {
    private Logger logger = LoggerFactory.getLogger(SysUserTest.class);

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Test
    public void test(){
        BigInteger id = BigInteger.valueOf(1L);
        List<SysResourceDto> list = sysResourceMapper.findResourcesBySysRoleId(id);
        list.stream().forEach(dto -> {
            System.out.println(dto.getResourceName());
        });
    }
}
