package com.alahr.springboot.redis.service;

public interface RedisService {
    void set(Object key, Object value);
    Object get(Object key);
}
