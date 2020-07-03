package com.itheima.mall.service.impl;

import com.itheima.mall.dao.OrderDao;
import com.itheima.mall.dao.OrderItemDao;
import com.itheima.mall.dao.ProductDao;
import com.itheima.mall.dao.impl.OrderDaoImpl;
import com.itheima.mall.dao.impl.OrderItemDaoImpl;
import com.itheima.mall.dao.impl.ProductDaoImpl;
import com.itheima.mall.pojo.Item;
import com.itheima.mall.pojo.Orders;
import com.itheima.mall.pojo.Product;
import com.itheima.mall.service.OrderService;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public void add(Orders orders, String[] ids, String[] amounts) {
        //添加订单，同时将订单的id返回
        int orderId = orderDao.add(orders);
        //添加订单项到订单中
        for(int i=0;i<ids.length;i++){
            //创建订单项对象
            Item item = new Item();
            item.setOrder_id(orderId);
            item.setProduct_id(Integer.parseInt(ids[i]));
            item.setAmount(Integer.parseInt(amounts[i]));

            Product product = productDao.findById(Integer.parseInt(ids[i]));
            item.setTotal_price(product.getPrice()*Integer.parseInt(amounts[i]));
            item.setPayment_price(product.getSale_price()*Integer.parseInt(amounts[i]));
            orderItemDao.add(item);
        }

    }

    @Override
    public void update(int status, String orderNumber) {
        orderDao.update(status,orderNumber);
    }
}
