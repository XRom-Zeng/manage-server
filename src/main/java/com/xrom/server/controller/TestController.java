package com.xrom.server.controller;

import com.xrom.server.entity.User;
import com.xrom.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XRom
 * @date: 2018-04-16 15:52:01
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/findById")
    public User findById(Long id) {
        return userService.selectById(id);
    }

    @GetMapping("/redis/set")
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @GetMapping("//redis/get")
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
