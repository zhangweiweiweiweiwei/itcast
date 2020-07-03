package com.itheima.mall.pojo;

public class Item implements java.io.Serializable {

    private Integer id;
    private Integer order_id;
    private Integer product_id;
    private Integer amount;
    private Double total_price;
    private Double payment_price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Double getPayment_price() {
        return payment_price;
    }

    public void setPayment_price(Double payment_price) {
        this.payment_price = payment_price;
    }
}
