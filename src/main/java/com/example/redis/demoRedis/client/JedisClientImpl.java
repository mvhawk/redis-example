package com.example.redis.demoRedis.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class JedisClientImpl implements JedisClient{

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    private  Jedis jedis;

    @Bean
    public Jedis GetJedis() {
        Jedis jedis = new Jedis("192.168.99.100", 7001);
        System.out.println("Test connection jedis ping : "+jedis.ping());
        return jedis;
    }
}
