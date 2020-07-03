package com.itheima.mall.dao;

import com.itheima.mall.pojo.Product;

import java.util.List;

public interface ProductDao {
    //获得当前分类商品信息集合
    public List<Product> findByCateId(int cateid);
    //查询当前分类商品的总记录数
    public long findTotalCount(int cateid);
    //查询当前的集合信息
    public List<Product> findByPage(int cateid,int start,int pageSize);
    //获得当前商品详情
    public Product findById(int id);
    //添加商品
    public void add(Product product);
}
