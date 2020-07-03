package com.itheima.mall.dao;

import com.itheima.mall.pojo.Orders;

public interface OrderDao {
    public int add(Orders orders);
    public void update(int status,String orderNumber);
}
