package com.cn;

import com.cn.mapper.UserMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int userID = 1;
            User user = userMapper.queryUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryAllUser(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> list = userMapper.queryAllUser();
            for(User user:list){
                System.out.println(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "dodo", "333666", "female");
            int insertResult = userMapper.insertUser(user);
            System.out.println(insertResult);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(5, "dodo", "777777", "female");
            int updateResult = userMapper.updateUser(user);
            System.out.println(updateResult);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testDeleteUserById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int id = 5;
            int deleteResult = userMapper.deleteUserById(id);
            System.out.println(deleteResult);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testInsertUserGetID1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "nini", "222666", "female");
            int insertResult = userMapper.insertUserGetID1(user);
            System.out.println(insertResult);
            Integer id = user.getId();
            System.out.println("执行插入操作后获得自动生成的主键id="+id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testInsertUserGetID2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "kpkp", "111999", "female");
            int insertResult = userMapper.insertUserGetID1(user);
            System.out.println(insertResult);
            Integer id = user.getId();
            System.out.println("执行插入操作后获得自动生成的主键id="+id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
