package com.cn.fms.service.impl;

import com.cn.fms.mapper.EmployeeMapper;
import com.cn.fms.pojo.Employee;
import com.cn.fms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(String name, String password) {
        Employee employee = employeeMapper.queryEmployeeByNameAndPassword(name, password);
        return employee;
    }

    @Override
    public List<Employee> queryByNameAndRole(String name, String roleID) {
        return employeeMapper.queryEmployeeByNameAndRole(name, roleID);
    }

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public Employee queryById(Integer id) {
        return employeeMapper.queryEmployeeById(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int delete(Integer id) {
        return employeeMapper.deleteEmployee(id);
    }

}
