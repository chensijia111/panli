package com.cn;

import com.cn.mapper.UserQueryMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MybatisQueryTest {

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            UserQueryMapper userQueryMapper = sqlSession.getMapper(UserQueryMapper.class);
            int userID = 1;
            User user = userQueryMapper.queryUserById(userID);
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testSelectOne() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 映射文件中queryUserById的完整路径
            String statement = "com.cn.mapper.UserQueryMapper.queryUserById";
            // 用户id
            int userID = 1;
            // 依据用户id查询用户
            User user = sqlSession.selectOne(statement, userID);
            // 打印用户信息
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
            UserQueryMapper userQueryMapper = sqlSession.getMapper(UserQueryMapper.class);
            List<User> list = userQueryMapper.queryAllUser();
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
    public void testSelectList() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 映射文件中queryAllUser的完整路径
            String statement = "com.cn.mapper.UserQueryMapper.queryAllUser";
            // 查询所有用户
            List<User> list = sqlSession.selectList(statement);
            // 遍历打印用户信息
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
    public void testGetUserCount(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserQueryMapper
            UserQueryMapper userQueryMapper = sqlSession.getMapper(UserQueryMapper.class);
            // 统计用户总量
            Integer count = userQueryMapper.getUserCount();
            System.out.println("用户总量 = "+count);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUserMapById(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserQueryMapper
            UserQueryMapper userQueryMapper = sqlSession.getMapper(UserQueryMapper.class);
            // 用户id
            int userID = 1;
            // 依据用户id查询用户
            Map<String, Object> map = userQueryMapper.queryUserMapById(userID);
            // 获取Map的KeySet
            Set<String> keySet = map.keySet();
            // 获取KeySet的迭代器
            Iterator<String> iterator = keySet.iterator();
            // 获取Map中的每个键及其对应的值
            while(iterator.hasNext()) {
                String key = iterator.next();
                Object value = map.get(key);
                System.out.println("key="+key+",value="+value);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryAllUserMap(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserQueryMapper
            UserQueryMapper userQueryMapper = sqlSession.getMapper(UserQueryMapper.class);
            // 获取所有用户
            Map<Integer, Object> map = userQueryMapper.queryAllUserMap();
            // 获取Map的KeySet
            Set<Integer> keySet = map.keySet();
            // 获取KeySet的迭代器
            Iterator<Integer> iterator = keySet.iterator();
            // 获取Map中的每个键及其对应的值
            while(iterator.hasNext()) {
                Integer key = iterator.next();
                Object value = map.get(key);
                System.out.println("key="+key+",value="+value);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testQueryUsersByLike() {
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取UserQueryMapper
            UserQueryMapper userQueryMapper = sqlSession.getMapper(UserQueryMapper.class);
            // 查询名字中包含xi的用户
            List<User> list = userQueryMapper.queryUsersByLike("xi");
            // 打印查询结果
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }


}
