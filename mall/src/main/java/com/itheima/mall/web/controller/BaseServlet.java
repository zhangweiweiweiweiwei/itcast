package com.itheima.mall.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取请求中的地址
        StringBuffer requestURL = request.getRequestURL();
        //获取地址中最后一根斜线的内容以，获取方法的名称
        String methodName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
        //获取对应的方法对象
        //1、获取子类的对象信息
        Class clz = this.getClass();
        //2、获取子类中对应的方法
        try {
            Method method=clz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void wirteJson(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("applection/json");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        response.getWriter().print(json);
    }
}
