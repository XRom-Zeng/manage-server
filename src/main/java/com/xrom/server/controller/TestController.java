package com.xrom.server.controller;

import com.xrom.server.entity.User;
import com.xrom.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这是一个用于测试的controller
 * @author: XRom
 * @date: 2018-04-16 15:52:01
 */
@Api(tags = "测试接口", description = "测试框架搭建环境基础接口访问")
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @ApiOperation(value = "根据id查询用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataTypeClass = Long.class)
    @GetMapping("/findById")
    @ResponseBody
    public User findById(Long id) {
        return userService.selectById(id);
    }


    @ApiOperation(value = "设置redis键值", notes = "设置redis键值对（测试redis）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "键", required = true, dataType = "String"),
            @ApiImplicitParam(name = "value", value = "值", required = true, dataType = "String")
    })
    @GetMapping("/redis/set")
    @ResponseBody
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @ApiOperation(value = "根据键获取值", notes = "根据键获取值（reds测试）")
    @ApiImplicitParam(name = "key", value = "键", required = true, dataType = "String")
    @GetMapping("//redis/get")
    @ResponseBody
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/temp")
    public String temp(ModelMap modelMap) {
        modelMap.addAttribute("msg", "hello thymeleaf");
        return "test";
    }
}
