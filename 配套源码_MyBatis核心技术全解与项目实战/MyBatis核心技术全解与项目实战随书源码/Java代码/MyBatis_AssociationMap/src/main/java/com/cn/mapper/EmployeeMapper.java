package com.cn.mapper;

import com.cn.pojo.Employee;

public interface EmployeeMapper {
    // 依据id查询员工方式1
    Employee findEmployeeById1(Integer id);
    // 依据id查询员工方式2
    Employee findEmployeeById2(Integer id);
}
