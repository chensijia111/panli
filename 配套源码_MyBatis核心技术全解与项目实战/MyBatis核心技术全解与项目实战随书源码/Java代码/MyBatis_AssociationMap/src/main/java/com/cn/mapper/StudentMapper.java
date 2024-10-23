package com.cn.mapper;

import com.cn.pojo.Student;
import com.cn.pojo.Teacher;

import java.util.List;

public interface StudentMapper {
    // 依据id查询学生方式1
    Student getStudentByID1(Integer id);
    // 依据id查询学生方式2
    Student getStudentByID2(Integer id);
    // 依据老师id查询学生
    List<Student> findStudents(Integer tid);
}
