package com.cn;

import com.cn.mapper.UserMapper;
import com.cn.mapper.UserMapper2;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test2 {
    @Test
    public void queryWithIf(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper
        UserMapper2 userMapper = sqlSession.getMapper(UserMapper2.class);
        List<User> userList=userMapper.queryWithIf("lucy",null);
        System.out.println(userList);
    }
    @Test
    public void queryWithWhere(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper
        UserMapper2 userMapper = sqlSession.getMapper(UserMapper2.class);
        List<User> userList=userMapper.queryWithIf(null,"123456");
        System.out.println(userList);

    }
    @Test
    public void queryWithChooes(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper
        UserMapper2 userMapper = sqlSession.getMapper(UserMapper2.class);
        List<User> userList=userMapper.queryWithIf(null,"123456");
        System.out.println(userList);
    }
}
