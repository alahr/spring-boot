package com.alahr.springboot.module.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringServiceImpl implements StringRedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
