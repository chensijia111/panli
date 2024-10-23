package com.cn.mapper;

import com.cn.pojo.Customer;

public interface CustomerMapper {
    // 依据id查询customer的错误方式
    Customer queryCustomerById0(Integer id);
    // 依据id查询customer方式1
    Customer queryCustomerById1(Integer id);
    // 依据id查询customer方式2
    Customer queryCustomerById2(Integer id);
    // 依据id查询customer方式3
    Customer queryCustomerById3(Integer id);
}
