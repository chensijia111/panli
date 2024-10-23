package com.cn;

import com.cn.mapper.CustomerMapper;
import com.cn.pojo.Customer;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
//Customer用于演示resultMap最基本的使用
public class MyBatisCustomerTest {

    @Test
    public void testQueryCustomerById0(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 客户id
            int customerID = 1;
            // 查询客户
            Customer customer = customerMapper.queryCustomerById0(customerID);
            // 打印查询结果
            System.out.println(customer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryCustomerById1(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 客户id
            int customerID = 1;
            // 查询客户
            Customer customer = customerMapper.queryCustomerById1(customerID);
            // 打印查询结果
            System.out.println(customer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryCustomerById2(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 客户id
            int customerID = 1;
            // 查询客户
            Customer customer = customerMapper.queryCustomerById2(customerID);
            // 打印查询结果
            System.out.println(customer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryCustomerById3(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 客户id
            int customerID = 1;
            // 查询客户
            Customer customer = customerMapper.queryCustomerById3(customerID);
            // 打印查询结果
            System.out.println(customer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
