package com.cn;

import com.cn.mapper.UserMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class MyBatisTestPro {

@Test
public void testQueryUserById() {
    SqlSession sqlSession = null;
    try {
        // 通过SqlSessionUtil工具类获取SqlSession
        sqlSession = SqlSessionUtil.getSqlSession();
        // 通过sqlSession获取UserMapper.java接口的代理实现类的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 调用UserMapper中的方法执行查询
        int userID = 1;
        User user = userMapper.queryUserById(userID);
        // 打印查询结果
        if(user!=null){
            System.out.println("用户信息："+user);
        }else{
            System.out.println("未查询到相关信息");
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // 通过SqlSessionUtil工具类关闭SqlSession
        SqlSessionUtil.closeSqlSession(sqlSession);
    }
}

@Test
public void testQueryAllUser(){
    SqlSession sqlSession = null;
    try {
        // 通过SqlSessionUtil工具类获取SqlSession
        sqlSession = SqlSessionUtil.getSqlSession();
        // 通过sqlSession获取UserMapper.java接口的代理实现类的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 查询所有用户
        List<User> list = userMapper.queryAllUser();
        // 遍历打印查询结果
        for(User user:list){
            System.out.println(user);
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // 通过SqlSessionUtil工具类关闭SqlSession
        SqlSessionUtil.closeSqlSession(sqlSession);
    }
}

@Test
public void testInsertUser(){
    SqlSession sqlSession = null;
    try {
        // 通过SqlSessionUtil工具类获取SqlSession
        sqlSession = SqlSessionUtil.getSqlSession();
        // 通过sqlSession获取UserMapper.java接口的代理实现类的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建User对象
        User user = new User(null, "dodo", "333666", "female");
        // 插入用户
        int result = userMapper.insertUser(user);
        // 打印插入结果
        if(result>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // 通过SqlSessionUtil工具类关闭SqlSession
        SqlSessionUtil.closeSqlSession(sqlSession);
    }
}

@Test
public void testUpdateUser(){
    SqlSession sqlSession = null;
    try {
        // 通过SqlSessionUtil工具类获取SqlSession
        sqlSession = SqlSessionUtil.getSqlSession();
        // 通过sqlSession获取UserMapper.java接口的代理实现类的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建User对象
        User user = new User(5, "dodo", "777777", "female");
        // 执行更新
        int result = userMapper.updateUser(user);
        // 打印更新结果
        if(result>0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // 通过SqlSessionUtil工具类关闭SqlSession
        SqlSessionUtil.closeSqlSession(sqlSession);
    }
}

@Test
public void testDeleteUserById(){
    SqlSession sqlSession = null;
    try {
        // 通过SqlSessionUtil工具类获取SqlSession
        sqlSession = SqlSessionUtil.getSqlSession();
        // 通过sqlSession获取UserMapper.java接口的代理实现类的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 用户id
        int id = 5;
        // 执行删除
        int result = userMapper.deleteUserById(id);
        // 打删除结果
        if(result>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        // 通过SqlSessionUtil工具类关闭SqlSession
        SqlSessionUtil.closeSqlSession(sqlSession);
    }
}

}
