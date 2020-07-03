package com.itheima.test;

import com.itheima.mall.utils.JedisUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    private Jedis jedis;

    @Before
    public void init(){
        //创建程序和Redis的连接，默认地址为本机，端口号为6379
        //jedis = new Jedis("localhost",6379);
        Jedis jedis = JedisUtil.getJedis();//通过连接池获取连接
    }

    @After
    public void destory(){
        //释放资源，关闭连接
        jedis.close();
    }

    @Test
    public void testString(){

        //添加字符串并获取
        jedis.set("mystring", "xiaobao");
        System.out.println(jedis.get("mystring"));

        //添加字符串并设置过期时间，可应用于验证码领域，分setex、expire两种、
        jedis.setex("mystring",20,"dabao");
        jedis.set("mystring","sanbao");
        jedis.expire("mystring",20);

    }
    @Test
    public void testHashMap(){

        // 存储hash
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");

        // 获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);
        // 获取hash的所有map中的数据,并利用迭代器遍历
        Map<String, String> user = jedis.hgetAll("user");
        //uesr.keySet()获取映射中包含的键的视图
        Iterator<String> iterator = user.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+"===>"+user.get(key));//get方法，获取指定键key所对应的值value
        }
        // keyset
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
    }

    @Test
    public void testList(){
        // list 存储
        jedis.lpush("mylist","a","b","c");//从左边存
        jedis.rpush("mylist","a","b","c");//从右边存

        // list 范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        // list 弹出
        String element1 = jedis.lpop("mylist");//c
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");//c
        System.out.println(element2);

        // list 范围获取
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);
    }

    @Test
    public void testSet(){
        //添加集合数据
        jedis.sadd("myset","java","php","c++");

        // 通过set获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
    }

    @Test
    public void testSortSet(){
        //2. 操作
        // sortedset 存储
        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",30,"后裔");
        jedis.zadd("mysortedset",55,"孙悟空");

        // sortedset 获取
        /*Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        for (String s:mysortedset){
            System.out.println(s+"\t");
        }*/
        //既获取分数又获取值
        Set<Tuple> mysortedset2 = jedis.zrangeWithScores("mysortedset",0,-1);
        for(Tuple tuple:mysortedset2){
            System.out.println(tuple.getScore()+"\t"+tuple.getElement());
        }
    }
}
