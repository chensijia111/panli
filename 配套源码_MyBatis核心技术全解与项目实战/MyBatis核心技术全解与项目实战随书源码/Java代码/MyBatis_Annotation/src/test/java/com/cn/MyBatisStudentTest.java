package com.cn;

import com.cn.mapper.StudentMapper;
import com.cn.pojo.Student;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//Student和Teacher用于演示多对多查询
public class MyBatisStudentTest {
    // 依据id查询学生
    @Test
    public void testGetStudentByID(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int studentID = 1;
            Student student = studentMapper.getStudentByID(studentID);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
