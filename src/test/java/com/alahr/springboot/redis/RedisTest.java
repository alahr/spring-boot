package com.alahr.springboot.redis;

import com.alahr.springboot.person.dto.Person;
import com.alahr.springboot.redis.service.RedisService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTest {
    private Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisService redisService;

    @Test
    public void test(){
        Person p = new Person();
        p.setId(BigInteger.valueOf(10010L));
        p.setName("孙岩");
        p.setGender("M");
        p.setAddress("shanghai");
        p.setBirthday("1998-12-23");

        logger.info(p.toString());

        redisService.set("alahr", JSON.parseObject(JSON.toJSONString(p)));

        JSONObject json = (JSONObject)redisService.get("alahr");
        logger.info(json.toString());
    }
}
