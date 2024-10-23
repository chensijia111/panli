package com.cn.pojo;

import java.util.List;

public class Teacher {
    private Integer tId;
    private String tName;
    private List<Student> studentList;

    public Teacher() {
    }

    public Teacher(Integer tId, String tName, List<Student> studentList) {
        this.tId = tId;
        this.tName = tName;
        this.studentList = studentList;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
