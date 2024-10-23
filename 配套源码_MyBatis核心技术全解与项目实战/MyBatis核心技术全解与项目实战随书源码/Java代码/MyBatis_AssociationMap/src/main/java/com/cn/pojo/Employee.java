package com.cn.pojo;

public class Employee {
    private Integer eId;
    private String eName;
    private Department department;

    public Employee() {
    }

    public Employee(Integer eId, String eName, Department department) {
        this.eId = eId;
        this.eName = eName;
        this.department = department;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", department=" + department +
                '}';
    }
}
