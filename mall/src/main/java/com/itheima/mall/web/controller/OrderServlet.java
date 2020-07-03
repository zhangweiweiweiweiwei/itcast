package com.itheima.mall.web.controller;

import com.itheima.mall.common.Result;
import com.itheima.mall.pojo.*;
import com.itheima.mall.service.AddressService;
import com.itheima.mall.service.OrderService;
import com.itheima.mall.service.ProductSerivce;
import com.itheima.mall.service.impl.AddressServiceImpl;
import com.itheima.mall.service.impl.OrderServiceImpl;
import com.itheima.mall.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/order/*")
public class OrderServlet extends BaseServlet {

    ProductSerivce productService = new ProductServiceImpl();
    AddressService addressService = new AddressServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    public void confirmOrder(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        //获取前台传过来的商品编号和数量
        String sids = request.getParameter("ids");
        String samounts = request.getParameter("amounts");

        String[] ids = sids.split(",");
        String[] amounts = samounts.split(",");

        //构造一个集合，将订单项的信息显示到前台
        List<CartItem> orderList = new ArrayList<>();

        for(int i=0; i<ids.length; i++){
            String id = ids[i]; //商品编号
            String amount = amounts[i];//获取数量
            Product product = productService.findById(Integer.parseInt(id));
            CartItem cartItem = new CartItem(product,Integer.parseInt(amount));
            orderList.add(cartItem);
        }

        Result result = new Result(true,orderList,"查询成功");

        wirteJson(response,result);
    }


    public void submitOrder(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //获取前台传过来的地址编号
        String address_id = request.getParameter("address_id");

        //获取商品的编号和数量
        String[] ids = request.getParameterValues("ids");
        String[] amounts = request.getParameterValues("amounts");

        //获取买家的留言
        String remark = request.getParameter("remark");

        //创建一个订单对象
        Orders orders = new Orders();
        orders.setStatus(0);        //0：表示未付款，1：表示已付款  2：表示未发货
        //产生订单号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderNumber = sdf.format(new Date());
        orders.setNumber(orderNumber);

        //获取订单地址信息
        Address address = addressService.findById(Integer.parseInt(address_id));
        orders.setConcat(address.getContact());
        orders.setZipcode(address.getZipcode());
        orders.setStreet(address.getStreet());
        orders.setMobile(address.getMobile());
        //设置买的编号
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        orders.setBuyer_id(member.getId());
        //设置备注
        orders.setRemark(remark);
        //设置订单生效日期
        orders.setCreate_time(new Date());

        int totalAmout=0;   //总数量
        double totalPrice=0;  //总价格
        double totalPayPrice=0; //实际支付的总价格
        //获取商品信息
        for(int i=0; i<ids.length; i++){
            Product product = productService.findById(Integer.parseInt(ids[i]));
            int amount = Integer.parseInt(amounts[i]);
            totalAmout+=amount;
            totalPrice+=product.getPrice()*amount;
            totalPayPrice+=product.getSale_price()*amount;
        }
        orders.setPayment_price(totalPayPrice);
        orders.setTotal_price(totalPrice);
        orders.setTotal_amount(totalAmout);

        //添加订单
        orderService.add(orders,ids,amounts);
        Result result = new Result(true,orders,"订单生成成功");
        wirteJson(response,result);
    }
}
