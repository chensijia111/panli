package com.cn;

import com.cn.mapper.PersonMapper;
import com.cn.pojo.Person;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
//Person和Card用于演示一对一查询
public class MyBatisPersonTest {
    // 依据id查询公民方式1
    @Test
    public void testFindPersonById1(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取PersonMapper
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            // 公民id
            int personID = 1;
            // 依据id查询公民
            Person person = personMapper.findPersonById1(personID);
            // 打印查询信息
            System.out.println(person);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 依据id查询公民方式2
    @Test
    public void testFindPersonById2(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取PersonMapper
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            // 公民id
            int personID = 1;
            // 依据id查询公民
            Person person = personMapper.findPersonById2(personID);
            // 打印查询信息
            System.out.println(person);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 依据id查询公民方式3
    @Test
    public void testFindPersonById3(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取PersonMapper
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            // 公民id
            int personID = 1;
            // 依据id查询公民
            Person person = personMapper.findPersonById3(personID);
            // 打印查询信息
            // System.out.println(person);
            System.out.println(person.getId());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }


}
