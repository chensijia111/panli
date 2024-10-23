package com.cn;

import com.cn.enums.GenderEnum;
import com.cn.mapper.EmployeeMapper;
import com.cn.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MyBatisMpAnnotationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testInsertEmployee(){
        // 创建员工对象
        Employee employee = new Employee();
        // 设置员工姓名
        employee.setName("hbhb");
        // 设置员工岁数
        employee.setAge(23);
        // 设置员工性别
        // 设置性别为枚举项将@EnumValue注解所标识的属性值存储到数据库
        employee.setGender(GenderEnum.FEMALE);
        // 设置员工状态
        employee.setStatus(0);
        // 执行插入
        int result = employeeMapper.insert(employee);
        // 打印插入结果
        if(result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testQueryAllEmployee(){
        // 查询所有员工
        List<Employee> employeeList = employeeMapper.selectList(null);
        // 打印查询结果
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testDeleteEmployee(){
        // 创建ArrayList对象保存员工id
        List<Long> idList = new ArrayList<>();
        // 添加第一个员工id
        idList.add(1L);
        // 添加第二个员工id
        idList.add(2L);
        // 添加第三个员工id
        idList.add(3L);
        // 执行批量删除
        int result = employeeMapper.deleteBatchIds(idList);
        // 打印删除结果
        if(result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

}
