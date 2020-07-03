package com.itheima.mall.service.impl;

import com.itheima.mall.dao.AddressDao;
import com.itheima.mall.dao.impl.AddressDaoImpl;
import com.itheima.mall.pojo.Address;
import com.itheima.mall.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao = new AddressDaoImpl();

    @Override
    public List<Address> findByMemberId(int memberId) {

        return addressDao.findByMemberId(memberId);
    }

    @Override
    public void addAddress(Address address) {
        //应该对是否为默认地址添加判断，若不是默认地址需将该会员所对应的地址的default_value更新为0
        if(address.getDefault_value()==0){
            addressDao.addAddress(address);
        }else{
            addressDao.updataDefaultValue(address.getMbr_id());
            addressDao.addAddress(address);
        }
    }

    @Override
    public Address findById(int id) {
        return addressDao.findById(id);
    }
}
