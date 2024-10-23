package com.cn.fms.service;

import com.cn.fms.pojo.Employee;
import java.util.List;

public interface EmployeeService {
    // 登录
    Employee login(String name, String password);
    // 依据id查询员工
    Employee queryById(Integer id);
    // 依据员工姓名和角色查询员工
    List<Employee> queryByNameAndRole(String name, String roleID);
    // 插入
    int insert(Employee employee);
    // 更新
    int update(Employee employee);
    // 删除
    int delete(Integer id);
}
