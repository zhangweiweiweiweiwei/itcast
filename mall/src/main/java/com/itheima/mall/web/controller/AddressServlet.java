package com.itheima.mall.web.controller;

import com.itheima.mall.common.Result;
import com.itheima.mall.dao.AddressDao;
import com.itheima.mall.pojo.Address;
import com.itheima.mall.pojo.Member;
import com.itheima.mall.pojo.Product;
import com.itheima.mall.service.AddressService;
import com.itheima.mall.service.impl.AddressServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/address/*")
public class AddressServlet extends BaseServlet {

    private AddressService addressService = new AddressServiceImpl();

    public void findByMember(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        //获取前台传过来的会员编号查找收货地址
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        Integer memberId = member.getId();
        //调用业务层根据会员ID获取对应的address
        List<Address> addressList = addressService.findByMemberId(memberId);
        Result result = new Result(true,addressList,"查询成功");
        wirteJson(response,result);
    }

    public void saveAddress(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

        //获取前台传过来的收货地址
        Map<String, String[]> parameterMap = request.getParameterMap();
        //打印map的方式
//        for(String key : parameterMap.keySet()){
//            System.out.print("Key = "+key+"value = "+parameterMap.get(key));
//        }
        Address address = new Address();
        try{
            BeanUtils.populate(address,parameterMap);
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
        //为地址设置对应的会员id
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        address.setMbr_id(member.getId());
        //调用业务层将address保存在数据库中
        //System.out.println(address);
        addressService.addAddress(address);
        Result result = new Result(true,"","查询成功");
        wirteJson(response,result);
    }
}
