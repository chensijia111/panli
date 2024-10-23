package com.cn;

import com.cn.mapper.UserSecondLevelCacheMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisSecondLevelCacheTest {

    @Test
    public void testQueryUserById1() {
        try {
            // 用户id
            int userID = 1;
            // 用户对象
            User user ;
            // 获取SqlSession
            SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
            // 获取UserSecondLevelCacheMapper
            UserSecondLevelCacheMapper userSecondLevelCacheMapper1 = sqlSession1.getMapper(UserSecondLevelCacheMapper.class);
            // 第一次查询id为1的用户
            user = userSecondLevelCacheMapper1.queryUserById(userID);
            // 打印查询结果
            System.out.println("第一次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession1.commit();

            // 获取SqlSession
            SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
            // 获取UserSecondLevelCacheMapper
            UserSecondLevelCacheMapper userSecondLevelCacheMapper2 = sqlSession2.getMapper(UserSecondLevelCacheMapper.class);
            // 第二次查询id为1的用户
            user = userSecondLevelCacheMapper2.queryUserById(userID);
            // 打印查询结果
            System.out.println("第二次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession2.commit();

            // 获取SqlSession
            SqlSession sqlSession3 = SqlSessionUtil.getSqlSession();
            // 获取UserSecondLevelCacheMapper
            UserSecondLevelCacheMapper userSecondLevelCacheMapper3 = sqlSession3.getMapper(UserSecondLevelCacheMapper.class);
            // 第三次查询id为1的用户
            user = userSecondLevelCacheMapper3.queryUserById(userID);
            // 打印查询结果
            System.out.println("第三次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession3.commit();

            // 获取SqlSession
            SqlSession sqlSession4 = SqlSessionUtil.getSqlSession();
            // 获取UserSecondLevelCacheMapper
            UserSecondLevelCacheMapper userSecondLevelCacheMapper4 = sqlSession4.getMapper(UserSecondLevelCacheMapper.class);
            // 第四次查询id为1的用户
            user = userSecondLevelCacheMapper4.queryUserById(userID);
            // 打印查询结果
            System.out.println("第四次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession4.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testQueryUserById2() {
        try {
            // 用户id
            int userID = 1;
            // 用户对象
            User user ;
            // 获取SqlSession
            SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
            // 获取UserSecondLevelCacheMapper
            UserSecondLevelCacheMapper userSecondLevelCacheMapper1 = sqlSession1.getMapper(UserSecondLevelCacheMapper.class);
            // 第一次查询id为1的用户
            user = userSecondLevelCacheMapper1.queryUserById(userID);
            // 打印查询结果
            System.out.println("第一次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession1.commit();

            // 获取SqlSession
            SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
            // 获取UserSecondLevelCacheMapper
            UserSecondLevelCacheMapper userSecondLevelCacheMapper2 = sqlSession2.getMapper(UserSecondLevelCacheMapper.class);
            // 用户对象
            User u = new User(2, "tata", "666777", "male");
            // 更新用户
            userSecondLevelCacheMapper2.updateUser(u);
            // SqlSession执行提交操作
            sqlSession2.commit();

            // 获取SqlSession
            SqlSession sqlSession3 = SqlSessionUtil.getSqlSession();
            // 获取UserSecondLevelCacheMapper
            UserSecondLevelCacheMapper userSecondLevelCacheMapper3 = sqlSession3.getMapper(UserSecondLevelCacheMapper.class);
            // 第二次查询id为1的用户，进行了更新操作，故从MySQL里查询
            user = userSecondLevelCacheMapper3.queryUserById(userID);
            // 打印查询结果
            System.out.println("第二次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession2.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
