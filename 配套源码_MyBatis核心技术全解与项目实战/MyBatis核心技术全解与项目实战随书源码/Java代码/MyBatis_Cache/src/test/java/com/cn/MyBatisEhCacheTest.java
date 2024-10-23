package com.cn;
//第三方缓存
import com.cn.mapper.UserEhCacheMapper;
import com.cn.mapper.UserLocalCacheMapper;
import com.cn.mapper.UserSecondLevelCacheMapper;
import com.cn.pojo.User;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisEhCacheTest {
    @Test
    public void testQueryUserById() {
        try {
            // 用户id
            int userID = 1;
            // 用户对象
            User user ;
            // 获取SqlSession
            SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
            // 获取UserEhCacheMapper
            UserEhCacheMapper userEhCacheMapper1 = sqlSession1.getMapper(UserEhCacheMapper.class);
            // 第一次查询id为1的用户，mysql
            user = userEhCacheMapper1.queryUserById(userID);
            // 打印查询结果
            System.out.println("第一次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession1.commit();

            // 获取SqlSession
            SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
            // 获取UserEhCacheMapper
            UserEhCacheMapper userEhCacheMapper2 = sqlSession2.getMapper(UserEhCacheMapper.class);
            // 第二次查询id为1的用户，缓存
            user = userEhCacheMapper2.queryUserById(userID);
            // 打印查询结果
            System.out.println("第二次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession2.commit();

            // 获取SqlSession
            SqlSession sqlSession3 = SqlSessionUtil.getSqlSession();
            // 获取UserEhCacheMapper
            UserEhCacheMapper userEhCacheMapper3 = sqlSession3.getMapper(UserEhCacheMapper.class);
            // 第三次查询id为1的用户，缓存

            user = userEhCacheMapper3.queryUserById(userID);
            // 打印查询结果
            System.out.println("第三次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession3.commit();

            // 获取SqlSession
            SqlSession sqlSession4 = SqlSessionUtil.getSqlSession();
            // 获取UserEhCacheMapper
            UserEhCacheMapper userEhCacheMapper4 = sqlSession4.getMapper(UserEhCacheMapper.class);
            // 第四次查询id为1的用户，缓存
            user = userEhCacheMapper4.queryUserById(userID);
            // 打印查询结果
            System.out.println("第四次查询结果："+user);
            // SqlSession执行提交操作
            sqlSession4.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
