package com.cn.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum GenderEnum {
    // 两个枚举对象
    FEMALE(0, "女"),
    MALE(1, "男");

    // 枚举的两个属性
    @EnumValue
    private Integer gender;
    private String genderName;

    GenderEnum(Integer gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }

    public Integer getGender() {
        return gender;
    }

    public String getGenderName() {
        return genderName;
    }

    @Override
    public String toString() {
        return "GenderEnum{" +
                "gender=" + gender +
                ", genderName='" + genderName + '\'' +
                "} " + super.toString();
    }
}
