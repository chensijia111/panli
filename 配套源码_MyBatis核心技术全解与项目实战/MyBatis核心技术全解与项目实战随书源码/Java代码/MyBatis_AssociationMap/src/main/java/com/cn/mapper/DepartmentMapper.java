package com.cn.mapper;

import com.cn.pojo.Department;

public interface DepartmentMapper {
    // 依据id查询部门
    Department findDepartmentById(Integer id);
}
