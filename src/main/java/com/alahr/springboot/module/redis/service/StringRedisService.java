package com.alahr.springboot.module.redis.service;

public interface StringRedisService {
    void set(String key, String value);
    String get(String key);
}
