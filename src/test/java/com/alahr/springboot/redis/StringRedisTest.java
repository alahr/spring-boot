package com.alahr.springboot.redis;

import com.alahr.springboot.redis.service.StringRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StringRedisTest {
    private Logger logger = LoggerFactory.getLogger(StringRedisTest.class);

    @Autowired
    private StringRedisService stringRedisService;

    @Test
    public void test(){
        stringRedisService.set("id", "123456");

        logger.info("id:{}", stringRedisService.get("id"));
        logger.info("username:{}", stringRedisService.get("username"));
        logger.info("age:{}", stringRedisService.get("age"));
        logger.info("birthday:{}", stringRedisService.get("birthday"));
        logger.info("gender:{}", stringRedisService.get("gender"));


    }
}
