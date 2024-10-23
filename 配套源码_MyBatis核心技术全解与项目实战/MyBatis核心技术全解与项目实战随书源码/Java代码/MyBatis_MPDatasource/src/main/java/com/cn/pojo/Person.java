package com.cn.pojo;

import com.baomidou.mybatisplus.annotation.*;

@TableName("t_person")
public class Person {
    @TableId(value = "p_id", type = IdType.AUTO)
    private Long id;
    @TableField("p_name")
    private String name;
    @TableField("p_gender")
    private String gender;
    @TableField("p_age")
    private Integer age;

    public Person() {
    }

    public Person(Long id, String name, String gender, Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
