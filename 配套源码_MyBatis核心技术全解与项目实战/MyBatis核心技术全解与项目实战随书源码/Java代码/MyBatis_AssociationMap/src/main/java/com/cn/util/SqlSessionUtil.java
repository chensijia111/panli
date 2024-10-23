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
        String fileName = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(fileName);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
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
