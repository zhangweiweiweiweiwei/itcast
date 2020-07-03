package com.itheima.mall.dao;

import com.itheima.mall.pojo.Address;

import java.util.List;

public interface AddressDao {
    public List<Address> findByMemberId(int memberId);
    public Address findById(int memberId);
    public void updataDefaultValue(int memberid);
    public void addAddress(Address address);
}
