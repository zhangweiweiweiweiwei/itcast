package com.itheima.test;

import com.itheima.mall.pojo.Category;

import com.itheima.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DBUtilsTest {
    
    @Test
    public void test6() throws Exception{
        //创建一个runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select count(*) from category";//count(*)为聚合函数

        Long count = runner.query(sql, new ScalarHandler<Long>());
        System.out.println(count);
    }

    @Test
    public void test5()throws  Exception{
        //创建一个runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select * from category ";
        List<Category> categoryList = runner.query(sql, new BeanListHandler<>(Category.class));

        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    @Test
    public void test4() {
        //创建一个runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        String sql = "select * from category where id=?";

        try {
            //此处BeanHandler<>(Category.class)对象为ResultSetHandler<T> rsh子类，运用反射技术获取到category对象并用category对象接收
            Category category = runner.query(sql, new BeanHandler<>(Category.class), 1);
            System.out.println(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){

        //创建一个runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的update()方法执行增、删、改
        String sql ="update category set name=?,alias=? where id=?";
        try {
            runner.update(sql,"家用电器","jiayongdianqi",28);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){

        //创建一个runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的update()方法执行增、删、改
        String sql ="delete from category where id=?";
        try {
            runner.update(sql,31);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){

        //创建一个runner对象
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

        //调用runner对象的update()方法执行增、删、改
        String sql ="insert into category values(null,?,?,?)";
        try {
            runner.update(sql,"日用百货1","riyongbaihuo1",10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
