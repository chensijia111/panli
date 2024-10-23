package com.cn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    // 初始化SqlSessionFactory对象
    static {
        // MyBatis核心配置文件名称
        String fileName = "mybatis-config.xml";
        try {
            // 获取文件输入流
            InputStream inputStream = Resources.getResourceAsStream(fileName);
            // 创建SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 创建SqlSessionFactory
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取SqlSession
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    // 关闭SqlSession
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }
}
