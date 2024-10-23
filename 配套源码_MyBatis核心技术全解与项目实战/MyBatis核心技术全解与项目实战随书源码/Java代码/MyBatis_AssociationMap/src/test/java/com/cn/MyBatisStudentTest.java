package com.cn;

import com.cn.mapper.StudentMapper;
import com.cn.pojo.Student;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
//Student和Teacher用于演示多对多查询
public class MyBatisStudentTest {
    // 依据id查询学生方式1
    @Test
    public void testGetStudentByID1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int studentID = 1;
            Student student = studentMapper.getStudentByID1(studentID);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 依据id查询学生方式2
    @Test
    public void testGetStudentByID2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int studentID = 1;
            Student student = studentMapper.getStudentByID2(studentID);
            System.out.println(student);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }


}
