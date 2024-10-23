package com.cn.mapper;

import com.cn.pojo.Person;

public interface PersonMapper {
    // 依据id查询公民方式1
    Person findPersonById1(Integer id);
    // 依据id查询公民方式2
    Person findPersonById2(Integer id);
    // 依据id查询公民方式2
    Person findPersonById3(Integer id);
}
