package com.itheima.mall.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.mall.common.Result;
import com.itheima.mall.pojo.Category;
import com.itheima.mall.service.CategoryService;
import com.itheima.mall.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        /**
         * 完全使用MySQL数据库
         */
//        List<Category> categoryList = categoryService.findAll();
//
//        Result result = new Result();
//        result.setFlag(true);
//        result.setMsg("查询成功");
//        result.setData(categoryList);
        /**
         * 使用MySQL+radis
         */
        response.setContentType("application/json");
        String allByRedis = categoryService.findAllById();
        response.getWriter().print(allByRedis);
        //原先冗余的代码
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(result);
//        response.getWriter().print(json);
    }
}
