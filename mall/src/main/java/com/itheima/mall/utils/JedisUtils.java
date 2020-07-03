package com.itheima.mall.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 单例模式，保证jedis连接池只有一个
 */
public class JedisUtils {

    //要保证连接池唯一
    private static JedisPool pool;

    //静态代码块中完成对pool的一个初始化（赋值）
    static{
        //在类路径下读取文件(类路径指的就是java与resources文件夹)
        InputStream inputStream = JedisUtil.class.getResourceAsStream("/jedis.properties");
        Properties p = new Properties();        //用于封装jdedis.propertis中的数据
        try {
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String host = p.getProperty("host");
        String port = p.getProperty("port");
        String maxTotal = p.getProperty("maxTotal");
        String maxIdle = p.getProperty("maxIdle");


        JedisPoolConfig config = new JedisPoolConfig();

        config.setMaxIdle(Integer.parseInt(maxIdle));
        config.setMaxTotal(Integer.parseInt(maxTotal));

        pool = new JedisPool(config,host,Integer.parseInt(port));


    }


    public static Jedis getJedis(){
        Jedis jedis = pool.getResource();
        return jedis;
    }
}
