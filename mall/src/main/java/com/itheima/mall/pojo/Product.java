package com.itheima.mall.pojo;

import java.util.Date;

public class Product implements java.io.Serializable {

    private Integer id;
    private String name;
    private Integer cate_id;
    private String thumbnail;
    private Integer inventory;
    private Integer sales_volume;
    private double price;
    private double sale_price;
    private String detail_description;
    private String selling_description;
    private Date create_time;
    private Date sale_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(Integer sales_volume) {
        this.sales_volume = sales_volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }

    public String getDetail_description() {
        return detail_description;
    }

    public void setDetail_description(String detail_description) {
        this.detail_description = detail_description;
    }

    public String getSelling_description() {
        return selling_description;
    }

    public void setSelling_description(String selling_description) {
        this.selling_description = selling_description;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getSale_time() {
        return sale_time;
    }

    public void setSale_time(Date sale_time) {
        this.sale_time = sale_time;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cate_id=" + cate_id +
                ", thumbnail='" + thumbnail + '\'' +
                ", inventory=" + inventory +
                ", sales_volume=" + sales_volume +
                ", price=" + price +
                ", sale_price=" + sale_price +
                ", detail_description='" + detail_description + '\'' +
                ", selling_description='" + selling_description + '\'' +
                ", create_time=" + create_time +
                ", sale_time=" + sale_time +
                '}';
    }
}
