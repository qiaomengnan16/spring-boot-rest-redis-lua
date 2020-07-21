package com.demo.spring.redis.lua.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class HelloRest {

    @Autowired
    private DefaultRedisScript<Boolean> redisScript;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "结果: " + redisTemplate.execute(redisScript, Arrays.asList("imKey"), "imValue"  , 20, new Date().getTime());
    }

}
