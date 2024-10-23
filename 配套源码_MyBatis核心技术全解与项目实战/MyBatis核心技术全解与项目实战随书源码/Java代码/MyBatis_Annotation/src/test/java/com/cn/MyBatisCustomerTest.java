package com.cn;

import com.cn.mapper.CustomerMapper;
import com.cn.pojo.Customer;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//Customer用于演示注解开发的基本知识
public class MyBatisCustomerTest {

    // 测试利用@Select注解依据id查询客户
    @Test
    public void testQueryCustomerById(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 客户id
            int customerID = 1;
            // 查询客户
            Customer customer = customerMapper.queryCustomerById(customerID);
            // 打印查询结果
            System.out.println("客户查询结果："+customer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用@Insert注解插入新客户
    @Test
    public void testInsertCustomer(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 创建客户对象
            Customer customer = new Customer(null, "momo", 19);
            // 插入客户
            int result = customerMapper.insertCustomer(customer);
            // 打印插入结果
            if(result > 0){
                System.out.println("插入客户成功");
            }else {
                System.out.println("插入客户失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用@Update注解更新原有客户
    @Test
    public void testUpdateCustomer(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 创建客户对象
            Customer customer = new Customer(4, "tata", 22);
            // 更新客户
            int result = customerMapper.updateCustomer(customer);
            // 打印更新结果
            if(result > 0){
                System.out.println("更新客户成功");
            }else {
                System.out.println("更新客户失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 测试利用@Delete注解依据id删除客户
    @Test
    public void testDeleteCustomerById(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取CustomerMapper
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            // 客户id
            int customerID = 1;
            // 删除客户
            int result = customerMapper.deleteCustomerById(customerID);
            // 打印删除结果
            if(result > 0){
                System.out.println("删除客户成功");
            }else {
                System.out.println("删除客户失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
