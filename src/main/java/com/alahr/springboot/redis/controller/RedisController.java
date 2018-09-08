package com.alahr.springboot.redis.controller;

import com.alahr.springboot.redis.service.RedisService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/get")
    public String get(@RequestParam("key") String key) {
        logger.info("key:{}", key);
        JSONObject o = (JSONObject) redisService.get(key);
        return o.toJSONString();
    }
}