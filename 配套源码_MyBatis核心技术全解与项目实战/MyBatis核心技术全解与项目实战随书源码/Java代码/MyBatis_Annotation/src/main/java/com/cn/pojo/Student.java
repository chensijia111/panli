package com.cn.pojo;

import java.util.List;

public class Student {
    private Integer sId;
    private String sName;
    private List<Teacher> teacherList;

    public Student() {
    }

    public Student(Integer sId, String sName, List<Teacher> teacherList) {
        this.sId = sId;
        this.sName = sName;
        this.teacherList = teacherList;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", teacherList=" + teacherList +
                '}';
    }
}
