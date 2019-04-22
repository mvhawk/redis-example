package com.example.redis.demoRedis.controller;

import com.example.redis.demoRedis.client.JedisClient;
import com.example.redis.demoRedis.model.JedisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class JedisRestController {

    @Autowired
    private JedisClient jedisClient;

    @PostMapping("/setSecret")
    void setSecret(@RequestBody JedisModel jedisModel) {
        jedisClient.GetJedis().set(jedisModel.getKey(), jedisModel.getValue());
        System.out.println("save: key:" + jedisModel.getKey() + "; value: " + jedisModel.getValue());
    }

    @GetMapping("/getSecret")
    String getSecret(@RequestParam(value="key", defaultValue="foo2") String key) {
        String value = jedisClient.GetJedis().get(key);
        System.out.println("get value: " + value +  "from key: "+ key);
        return value;
    }
}


