package com.example.redis.demoRedis.client;

import redis.clients.jedis.Jedis;

public interface JedisClient {
    public Jedis GetJedis();
}
