package com.api.hospital.controller;

import io.swagger.annotations.Api;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "首页接口")
@RestController
public class MainController {

    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/re")
    public Object re() {
        return redisTemplate.opsForValue().get("postsList");
    }

}
