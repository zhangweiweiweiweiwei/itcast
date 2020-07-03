package com.itheima.mall.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.mall.dao.CategoryDao;
import com.itheima.mall.dao.impl.CategoryDaoImpl;
import com.itheima.mall.pojo.Category;
import com.itheima.mall.service.CategoryService;
import com.itheima.mall.utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {

        return categoryDao.findAll();
    }

    @Override
    public String findAllById() {

        Jedis jedis = JedisUtil.getJedis();
        //1.判断Redis中是否有category信息
        String categoryJSON = jedis.get("CATEGORY");
        if(categoryJSON == null || categoryJSON.length() <= 0){
            //若不存在，在数据库中查询并返回
            List<Category> all = categoryDao.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            try{
                categoryJSON = objectMapper.writeValueAsString(all);
            } catch (JsonProcessingException e){
                e.printStackTrace();
            }
            jedis.set("CATEGORY",categoryJSON);
            System.out.println("访问了MySQL数据库");
        }else{
            System.out.println("访问了Redis数据库");
        }
        //若存在直接返回
        return categoryJSON;
    }

}
