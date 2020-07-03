package com.itheima.mall.dao.impl;

import com.itheima.mall.dao.OrderDao;
import com.itheima.mall.pojo.Orders;
import com.itheima.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class OrderDaoImpl implements OrderDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public int add(Orders orders) {
        String sql = "insert into orders values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int id=0;
        try {
            queryRunner.update(sql, orders.getNumber(), orders.getBuyer_id(), orders.getTotal_amount(), orders.getTotal_price(), orders.getPayment_price(), orders.getRemark(), orders.getConcat(), orders.getMobile(), orders.getStreet(), orders.getZipcode(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(orders.getCreate_time()), orders.getPayment_time(), orders.getDelivery_time(), orders.getEnd_time(), orders.getStatus());
            BigInteger lid=queryRunner.query("select last_insert_id()",new ScalarHandler<BigInteger>());  //获取最近一次添加语句所产生的自增列的值

            id= lid.intValue();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(int status, String orderNumber) {
        String sql = "update orders set status=? where number=?";
        try{
            queryRunner.update(sql,status,orderNumber);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
