package com.itheima.mall.dao;

import com.itheima.mall.pojo.Member;

public interface MemberDao {

    public Member findByMobileAndPwd(String mobile, String pwd);

    public Member findByMobile(String mobile);

    public void add(Member member);
}
