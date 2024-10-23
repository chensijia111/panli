package com.cn;

import java.io.InputStream;
import com.cn.mapper.UserMapper;
import com.cn.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisTest {

    @Test
    public void testSelectUserById() {
        SqlSession sqlSession = null;
        try {
            // 读取MyBatis核心配置文件mybatis-config.xml
            String fileName = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(fileName);
            // 创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 通过SqlSessionFactoryBuilder解析配置文件获取sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            // 通过SqlSessionFactory对象创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            // 通过sqlSession获取UserMapper.java接口的代理实现类的对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用UserMapper中的方法执行查询
            String userID = "1";
            User user = userMapper.selectUserById(userID);
            // 打印查询结果
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭SqlSession
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
