package com.itheima.mall.dao.impl;

import com.itheima.mall.dao.OrderItemDao;
import com.itheima.mall.pojo.Item;
import com.itheima.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class OrderItemDaoImpl implements OrderItemDao {
    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());


    @Override
    public void add(Item item) {
        String sql = "insert into item values(null,?,?,?,?,?)";
        try {
            runner.update(sql,item.getOrder_id(),item.getProduct_id(),item.getAmount(),item.getTotal_price(),item.getPayment_price());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}