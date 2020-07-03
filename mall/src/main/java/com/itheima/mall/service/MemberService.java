package com.itheima.mall.service;

import com.itheima.mall.pojo.Member;

public interface MemberService {

     Member login(String mobile, String pwd);


     boolean regist(Member member);
}
