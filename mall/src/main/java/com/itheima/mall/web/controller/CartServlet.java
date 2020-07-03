package com.itheima.mall.web.controller;

import com.itheima.mall.common.Result;
import com.itheima.mall.pojo.CartItem;
import com.itheima.mall.pojo.Product;
import com.itheima.mall.service.ProductSerivce;
import com.itheima.mall.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart/*")
public class CartServlet extends BaseServlet {

    private ProductSerivce productSerivce = new ProductServiceImpl();

    public void addCart(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {

        //获取前台传来的商品编号和数量
        int productId = Integer.parseInt(request.getParameter("productId"));
        int number = Integer.parseInt(request.getParameter("number"));
        //System.out.println(productId);
        //创建一个购物车项
        Product product = productSerivce.findById(productId);
        CartItem cartItem = new CartItem(product,number);
        //获取购物车,采用session而不是数据库来存储相关数据
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if(cart==null){
            cart = new ArrayList<>();//若是第一次购物测创建购物车
        }
        cart.add(cartItem);//将购物车项加入购物车
        //System.out.println(cart);
        session.setAttribute("cart",cart);

        Result result = new Result();
        result.setFlag(true);
        result.setMsg("添加成功");
        //System.out.println(result);
        wirteJson(response,result);
    }

    public void viewCart(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {

        //获取session
        HttpSession session = request.getSession();
        //从session中取出购物车对象（list）
        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
        Result result = new Result();
        if(cart == null){
            result.setFlag(false);
            result.setMsg("购物车为空");
        }else {
            result.setFlag(true);
            result.setMsg("查询成功");
            result.setData(cart);
        }
        wirteJson(response,result);
    }
}
