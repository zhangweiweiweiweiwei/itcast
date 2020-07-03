package com.itheima.mall.service;

import com.itheima.mall.pojo.Address;

import java.util.List;

public interface AddressService {
    public List<Address>findByMemberId(int memberId);
    public void addAddress(Address address);
    public Address findById(int id);
}
