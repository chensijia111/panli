package com.cn.fms.mapper;

import com.cn.fms.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface EmployeeMapper {
    // 依据姓名和密码查询员工
    Employee queryEmployeeByNameAndPassword(@Param("name") String name, @Param("password") String password);
    // 依据姓名和角色查询员工
    List<Employee> queryEmployeeByNameAndRole(@Param("name") String name, @Param("roleID") String roleID);
    // 新增员工
    int insertEmployee(Employee employee);
    // 依据id查询员工
    Employee queryEmployeeById(Integer id);
    // 更新员工
    int updateEmployee(Employee employee);
    // 删除员工
    int deleteEmployee(Integer id);
}
