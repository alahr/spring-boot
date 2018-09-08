package com.alahr.springboot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;


    public void set(Object key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(Object key){
        return redisTemplate.opsForValue().get(key);
    }
}
