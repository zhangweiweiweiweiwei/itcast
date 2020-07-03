package com.itheima.mall.pojo;

public class CartItem implements java.io.Serializable {

    private Product product;
    private int number;

    public CartItem() {

    }

    public CartItem(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", number=" + number +
                '}';
    }
}
