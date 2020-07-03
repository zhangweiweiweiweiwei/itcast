package com.itheima.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class jedisPoolTest {
    @Test
    public void test1(){
        //设置连接参数
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setMaxTotal(20);
        //创建连接池
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
        Jedis jedis = jedisPool.getResource();

        jedis.set("name","erbao");
        System.out.println(jedis.get("name"));
    }
}
