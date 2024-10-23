package com.cn;

import com.cn.mapper.TeacherMapper;
import com.cn.pojo.Teacher;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//Student和Teacher用于演示多对多查询
public class MyBatisTeacherTest {
    // 依据id查询老师
    @Test
    public void testGetTeacherByID(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            int teacherID = 1;
            Teacher teacher = teacherMapper.getTeacherByID(teacherID);
            System.out.println(teacher);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
}
