package com.cn;

import com.cn.mapper.EmployeeMapper;
import com.cn.pojo.Employee;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//Employee和Department用于演示多对一查询
public class MyBatisEmployeeTest {
    // 依据id查询员工
    @Test
    public void testFindEmployeeById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            int employeeID = 1;
            Employee employee = employeeMapper.findEmployeeById(employeeID);
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
}
