package com.itheima.mall.service;

import com.itheima.mall.pojo.Orders;

public interface OrderService {
    //添加订单的同时，添加订单项
    public void add(Orders orders,String[] ids,String[] amounts);
    public void update(int status,String orderNumber);
}
