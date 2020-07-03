package com.itheima.mall.service;

import com.itheima.mall.pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public String findAllById();
}
