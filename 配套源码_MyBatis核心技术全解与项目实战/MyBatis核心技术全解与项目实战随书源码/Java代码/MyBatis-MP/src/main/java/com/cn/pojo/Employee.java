package com.cn.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.cn.enums.GenderEnum;

@TableName("t_employee")
public class Employee {
    @TableId(value = "e_id",type = IdType.AUTO)
    private Long id;
    @TableField("e_name")
    private String name;
    @TableField("e_gender")
    private GenderEnum gender;
    @TableField("e_age")
    private Integer age;
    @TableLogic
    private Integer status;

    public Employee() {
    }

    public Employee(Long id, String name, GenderEnum gender, Integer age, Integer status) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}


