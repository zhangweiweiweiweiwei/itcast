package com.itheima.mall.service;

import com.itheima.mall.common.PageBean;
import com.itheima.mall.pojo.Product;

import java.util.List;

public interface ProductSerivce {
    //根据商品分类进行查询
    public List<Product> findByCateId(int cateid);
    //根据商品分类进行分页查询
    public PageBean<Product> findPage(int cateid, int currentPage, int pageSize);
    //根据id查询
    public Product findById(int id);

    public void add(Product product);
}
