package com.cn.mapper;

import com.cn.pojo.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {
    // 依据id查询部门
    @Select("select * from department where d_id = #{id}")
    Department findDepartmentById(Integer id);
}
