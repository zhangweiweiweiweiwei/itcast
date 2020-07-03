package com.itheima.mall.pojo;

public class Address implements java.io.Serializable {
    private Integer id;
    private String contact;
    private String mobile;
    private String street;
    private String zipcode;
    private Integer mbr_id;
    private int default_value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getMbr_id() {
        return mbr_id;
    }

    public void setMbr_id(Integer mbr_id) {
        this.mbr_id = mbr_id;
    }

    public int getDefault_value() {
        return default_value;
    }

    public void setDefault_value(int default_value) {
        this.default_value = default_value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", mobile='" + mobile + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", mbr_id=" + mbr_id +
                ", default_value=" + default_value +
                '}';
    }
}
