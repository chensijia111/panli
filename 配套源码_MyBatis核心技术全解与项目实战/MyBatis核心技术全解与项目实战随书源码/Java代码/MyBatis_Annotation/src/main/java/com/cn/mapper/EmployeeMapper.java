package com.cn.mapper;

import com.cn.pojo.Employee;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {
    // 依据id查询员工
    @Select("select * from employee where e_id = #{id}")
    @Results({
            @Result(id = true,column = "e_id",property = "eId"),
            @Result(column = "e_name",property = "eName"),
            @Result(column = "d_id",property = "department",
                    one = @One(select = "com.cn.mapper.DepartmentMapper.findDepartmentById"))
    })
    Employee findEmployeeById(Integer id);
}
