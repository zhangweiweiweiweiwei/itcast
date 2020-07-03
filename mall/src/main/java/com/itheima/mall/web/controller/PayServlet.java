package com.itheima.mall.web.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.itheima.mall.common.Result;
import com.itheima.mall.pojo.Address;
import com.itheima.mall.pojo.Member;
import com.itheima.mall.service.OrderService;
import com.itheima.mall.service.impl.OrderServiceImpl;
import com.itheima.mall.utils.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet("/pay/*")
public class PayServlet extends BaseServlet {

    OrderService orderService = new OrderServiceImpl();

    //创建支付宝支付链接
    public void creatPayForm(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

        //接收支付方式
        String checkway = request.getParameter("checkway");
        //接收订单编号
        String orderNumber = request.getParameter("orderNumber");
        //接收到支付金额
        String payMoney = request.getParameter("payMoney");

        if ("alipay".equals(checkway)) {
            if (orderNumber != null) {
                // 商户订单号，商户网站订单系统中唯一订单号，必填
                String out_trade_no = new String(orderNumber.getBytes("ISO-8859-1"), "UTF-8");
                // 订单名称，必填
                String subject = new String(orderNumber.getBytes("ISO-8859-1"), "UTF-8");
                // 付款金额，必填
                String total_amount = new String(payMoney.getBytes("ISO-8859-1"), "UTF-8");
                // 商品描述，可空
                String body = "";
                // 超时时间 可空
                String timeout_express = "2m";
                // 销售产品码 必填
                String product_code = "FAST_INSTANT_TRADE_PAY";//直接使用二维码付款
                /**********************/
                // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
                //调用RSA签名方式
                AlipayClient client = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.FORMAT, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
                //使用页面端支付方式
                AlipayTradePagePayRequest alipay_request = new AlipayTradePagePayRequest();

                // 封装请求支付信息(手机端)

                AlipayTradePagePayModel model = new AlipayTradePagePayModel();
                model.setOutTradeNo(out_trade_no);
                model.setSubject(subject);
                model.setTotalAmount(total_amount);
                model.setBody(body);
                model.setTimeoutExpress(timeout_express);
                model.setProductCode(product_code);
                alipay_request.setBizModel(model);


                // 设置异步通知地址
                alipay_request.setNotifyUrl(AlipayConfig.notify_url);
                // 设置同步地址
                alipay_request.setReturnUrl(AlipayConfig.return_url);

                // form表单生产
                String form = "";
                try {
                    // 调用SDK生成表单
                    form = client.pageExecute(alipay_request).getBody();
                    response.setContentType("text/html;charset=" + AlipayConfig.charset);
                    response.getWriter().write(form);//直接将完整的表单html输出到页面
                    System.out.println(form);
                    response.getWriter().flush();
                    response.getWriter().close();
                } catch (AlipayApiException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } else if ("weixin".equals(checkway)) {

        }


    }

    //接收支付宝返回通知
    public void alipayReturnNotice(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{

        PrintWriter out = response.getWriter();

        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号

        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        //验证上面的信息是不是由支付宝给我们返回的
        boolean verify_result = false;
        try {
            verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, "RSA2");
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if(verify_result){//验证成功

            //如果用户支付成功
            //1、将订单的状态修改为1(已支付)
            orderService.update(1,out_trade_no);
            //2、要将产品的销售数量加1

            out.println("验证成功<br />");

        }else{
            //该页面可做页面美工编辑

            out.println("验证失败");
        }
    }


}
