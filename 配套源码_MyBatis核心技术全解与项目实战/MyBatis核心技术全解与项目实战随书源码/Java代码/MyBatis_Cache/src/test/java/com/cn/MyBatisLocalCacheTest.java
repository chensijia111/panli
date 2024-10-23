package com.cn;

import com.cn.mapper.UserLocalCacheMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisLocalCacheTest {

    @Test
    public void testQueryUserById1() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserLocalCacheMapper
            UserLocalCacheMapper userLocalCacheMapper = sqlSession.getMapper(UserLocalCacheMapper.class);
            // 用户id
            int userID = 1;
            // 第一次查询id为1的用户,从数据库查询
            User user = userLocalCacheMapper.queryUserById(userID);
            // 打印查询结果
            System.out.println("第一次查询结果："+user);
            // 第二次查询id为1的用户，从一级缓存中获取
            user = userLocalCacheMapper.queryUserById(userID);
            // 打印查询结果
            System.out.println("第二次查询结果："+user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUserById2() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserLocalCacheMapper
            UserLocalCacheMapper userLocalCacheMapper = sqlSession.getMapper(UserLocalCacheMapper.class);
            // 用户id
            int userID = 1;
            // 第一次查询id为1的用户，从mysql
            User user = userLocalCacheMapper.queryUserById(userID);
            // 打印查询结果
            System.out.println("第一次查询结果："+user);
            // 创建用户对象
            User u = new User(2, "tata", "666777", "male");
            // 更新id为2的用户，有更新（增删改）操作，缓存失效
            userLocalCacheMapper.updateUser(u);
            // 第二次查询id为1的用户，从mysql
            user = userLocalCacheMapper.queryUserById(userID);
            // 打印查询结果
            System.out.println("第二次查询结果："+user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    /**
     * 验证性实验，非书中内容。
     * 该验证与testQueryUserById1()相对于
     * 在第二次查询前重新获取SqlSession和UserLocalCacheMapper
     */
    @Test
    public void testQueryUserById3() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserLocalCacheMapper
            UserLocalCacheMapper userLocalCacheMapper = sqlSession.getMapper(UserLocalCacheMapper.class);
            // 用户id
            int userID = 1;
            // 第一次查询id为1的用户，从mysql
            User user = userLocalCacheMapper.queryUserById(userID);
            // 打印查询结果
            System.out.println("第一次查询结果："+user);
            // 注意：重新获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 注意：重新获取UserLocalCacheMapper
            userLocalCacheMapper = sqlSession.getMapper(UserLocalCacheMapper.class);
            // 第二次查询id为1的用户,从mysql，两次sqlsession
            user = userLocalCacheMapper.queryUserById(userID);
            // 打印查询结果
            System.out.println("第二次查询结果："+user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
