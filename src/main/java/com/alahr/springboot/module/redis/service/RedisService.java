package com.alahr.springboot.module.redis.service;

public interface RedisService {
    void set(Object key, Object value);
    Object get(Object key);
}
