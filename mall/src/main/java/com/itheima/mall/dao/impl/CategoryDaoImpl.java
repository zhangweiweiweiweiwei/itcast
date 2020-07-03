package com.itheima.mall.dao.impl;

import com.itheima.mall.dao.CategoryDao;
import com.itheima.mall.pojo.Category;
import com.itheima.mall.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll(){
        String sql = "select * from category";

        try{
            List<Category> categoryList = runner.query(sql,new BeanListHandler<>(Category.class));
            return categoryList;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
