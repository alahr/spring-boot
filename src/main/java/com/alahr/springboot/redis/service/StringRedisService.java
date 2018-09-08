package com.alahr.springboot.redis.service;

public interface StringRedisService {
    void set(String key, String value);
    String get(String key);
}
