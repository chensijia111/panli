package com.cn;

import com.cn.mapper.PersonMapper;
import com.cn.pojo.Person;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//Person和Card用于演示一对一查询
public class MyBatisPersonTest {

    @Test
    public void testFindPersonById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            int personID = 1;
            Person person = personMapper.findPersonById(personID);
            System.out.println(person);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
