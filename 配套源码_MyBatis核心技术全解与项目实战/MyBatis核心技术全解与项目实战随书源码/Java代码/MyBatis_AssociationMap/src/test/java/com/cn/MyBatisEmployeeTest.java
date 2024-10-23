package com.cn;

import com.cn.mapper.EmployeeMapper;
import com.cn.pojo.Employee;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
//Employee和Department用于演示多对一查询
public class MyBatisEmployeeTest {
    // 依据id查询员工方式1
    @Test
    public void testFindEmployeeById1(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取EmployeeMapper
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            // 员工id
            int employeeID = 1;
            // 依据id查询员工
            Employee employee = employeeMapper.findEmployeeById1(employeeID);
            // 打印查询信息
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 依据id查询员工方式2
    @Test
    public void testFindEmployeeById2(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取EmployeeMapper
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            // 员工id
            int employeeID = 1;
            // 依据id查询员工
            Employee employee = employeeMapper.findEmployeeById2(employeeID);
            // 打印查询信息
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
