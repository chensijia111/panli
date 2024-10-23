package com.cn;

import com.cn.mapper.TeacherMapper;
import com.cn.pojo.Student;
import com.cn.pojo.Teacher;
import com.cn.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

//Student和Teacher用于演示多对多查询
public class MyBatisTeacherTest {
    // 依据id查询老师方式1
    @Test
    public void testGetTeacherByID1(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取TeacherMapper
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            // 教师id
            int teacherID = 1;
            // 查询教师信息
            Teacher teacher = teacherMapper.getTeacherByID1(teacherID);
            // 打印教师信息
            System.out.println(teacher.gettId());
            System.out.println(teacher.gettName());
            List<Student> list = teacher.getStudentList();
            for(Student student : list){
                System.out.println(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

    // 依据id查询老师方式2
    @Test
    public void testGetTeacherByID2(){
        SqlSession sqlSession = null;
        try {
            // 获取SqlSession
            sqlSession = SqlSessionUtil.getSqlSession();
            // 获取TeacherMapper
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            // 教师id
            int teacherID = 1;
            // 查询教师信息
            Teacher teacher = teacherMapper.getTeacherByID2(teacherID);
            // 打印教师信息
            System.out.println(teacher.gettId());
            System.out.println(teacher.gettName());
            List<Student> list = teacher.getStudentList();
            for(Student student : list){
                System.out.println(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }

}
