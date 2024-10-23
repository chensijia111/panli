package com.cn;

import com.cn.mapper.UserParameterMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.*;

public class MybatisParameterTest {

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 用户id
            int userID = 1;
            // 依据用户id查询用户
            User user = userParameterMapper.queryUserById(userID);
            // 打印用户
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByUsernameAndGender() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 用户名
            String username = "lucy";
            // 用户性别
            String gender = "female";
            // 查询用户
            List<User> list = userParameterMapper.queryUsersByUsernameAndGender(username, gender);
            // 打印用户
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByUsernameOrGender() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 用户名
            String username = "lucy";
            // 用户性别
            String gender = "female";
            // 查询用户
            List<User> list = userParameterMapper.queryUsersByUsernameOrGender(username, gender);
            // 打印用户
            for(User user : list){
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 用户名
            String username = "gugu";
            // 密码
            String password = "123456";
            // 用户性别
            String gender = "female";
            // 创建用户对象
            User user = new User(null, username, password, gender);
            // 插入用户
            int result = userParameterMapper.insertUser(user);
            // 打印插入操作结果
            if(result>0){
                System.out.println("插入用户成功");
            }else {
                System.out.println("插入用户失败");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByTwoUser() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 用户名
            String username = "hghg";
            // 密码
            String password = "123456";
            // 用户性别
            String gender = "female";
            // 创建第一个User对象
            User user1 = new User(null, username, password, gender);
            // 用户名
            username = "pkpk";
            // 密码
            password = "123456";
            // 用户性别
            gender = "female";
            // 创建第二个User对象
            User user2 = new User(null, username, password, gender);
            // 查询用户
            List<User> list = userParameterMapper.queryUsersByTwoUser(user1, user2);
            // 打印查询结果
            for(User user : list){
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByTwoUserWithParam() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 用户名
            String username = "hghg";
            // 密码
            String password = "123456";
            // 用户性别
            String gender = "female";
            // 创建第一个User对象
            User user1 = new User(null, username, password, gender);
            // 用户名
            username = "pkpk";
            // 密码
            password = "123456";
            // 用户性别
            gender = "female";
            // 创建第二个User对象
            User user2 = new User(null, username, password, gender);
            // 查询用户
            List<User> list = userParameterMapper.queryUsersByTwoUserWithParam(user1, user2);
            // 打印查询结果
            for(User user : list){
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByMap() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 创建Map对象
            Map<String, Object> paramMap=new HashMap<>();
            // 以username为键lucy为值向Map中添加数据
            paramMap.put("username", "lucy");
            // 以gender为键female为值向Map中添加数据
            paramMap.put("gender", "female");
            // 查询用户
            List<User> list = userParameterMapper.queryUsersByMap(paramMap);
            // 打印查询结果
            for(User user : list){
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByList() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 创建List
            List<Integer> idList=new ArrayList<>();
            // 利用List保存用户id
            idList.add(1);
            idList.add(2);
            idList.add(3);
            // 查询用户
            List<User> list = userParameterMapper.queryUsersByList(idList);
            // 打印查询结果
            for(User user : list){
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByArray() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserParameterMapper
            UserParameterMapper userParameterMapper = sqlSession.getMapper(UserParameterMapper.class);
            // 利用数组保存用户id
            int[] idArray = {1,2,3};
            // 查询用户
            List<User> list = userParameterMapper.queryUsersByArray(idArray);
            // 打印查询结果
            for(User user : list){
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
