package com.itheima.mall.web.controller;

import com.itheima.mall.common.PageBean;
import com.itheima.mall.common.Result;
import com.itheima.mall.pojo.Category;
import com.itheima.mall.pojo.Product;
import com.itheima.mall.service.CategoryService;
import com.itheima.mall.service.ProductSerivce;
import com.itheima.mall.service.impl.CategoryServiceImpl;
import com.itheima.mall.service.impl.ProductServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {

    private ProductSerivce productSerivce =  new ProductServiceImpl();

    public void findByCate(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {

        //获取前台传过来的分类编号
        String cate_id = request.getParameter("cate_id");
        System.out.println(cate_id);
        int cateid = 0;
        if (cate_id!=null)
            cateid = Integer.parseInt(cate_id);
        //调用业务层根据分类来进行商品的查询
        List<Product> productList =  productSerivce.findByCateId(cateid);
        System.out.println(productList);
        Result result = new Result(true,productList,"登录成功");
        wirteJson(response,result);
    }

    public void findPage(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //获取到前台传过来的分类编号
        String categoryId = request.getParameter("categoryId");
        //获取前台传过来的当前页
        String page = request.getParameter("currentPage");
        //获取每页显示的记录数
        String size = request.getParameter("pageSize");

        int cateId=0;
        if(categoryId!=null){
            cateId=Integer.parseInt(categoryId);
        }

        int currenPage=1;  //如果前台没有传递当前页，则默认值为1
        if(page!=null){
            currenPage=Integer.parseInt(page);
        }

        int pageSize=10;//如果前台没有传递每页条数，则默认值为10
        if(size!=null){
            pageSize= Integer.parseInt(size);
        }

        PageBean<Product> pageBean = productSerivce.findPage(cateId, currenPage, pageSize);
        wirteJson(response,pageBean);
    }

    public void findById(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //获取前台传过来的商品编号
        String sid = request.getParameter("productId");
        int productid = 0;
        if (sid!=null)
            productid = Integer.parseInt(sid);
        //调用业务层根据分类来进行商品的查询
        //System.out.println(productid);
        Product product =  productSerivce.findById(productid);
        Result result = new Result(true,product,"登录成功");
        //将result转换为json
        wirteJson(response,result);
    }

    public void add(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        Map<String, String[]> parameterMap = request.getParameterMap();
        Product product = new Product();
        try {
            BeanUtils.populate(product,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        product.setSale_time(new Date());
        product.setCreate_time(new Date());

        productSerivce.add(product);
        Result result = new Result(true,"","添加成功");
        //将result转换为json
        wirteJson(response,result);
    }
}
