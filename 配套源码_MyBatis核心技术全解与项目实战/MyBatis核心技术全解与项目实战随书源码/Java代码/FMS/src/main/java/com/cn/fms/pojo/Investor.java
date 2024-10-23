package com.cn.fms.pojo;

import java.util.Date;

public class Investor {
    private int id;
    private String name;
    private String level;
    private String amount;
    private String field;
    private String intent;
    private String city;
    private String number;
    private String note;
    private Date createTime;

    public Investor() {
    }

    public Investor(int id, String name, String level, String amount, String field, String intent, String city, String number, String note, Date createTime) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.amount = amount;
        this.field = field;
        this.intent = intent;
        this.city = city;
        this.number = number;
        this.note = note;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", amount='" + amount + '\'' +
                ", field='" + field + '\'' +
                ", intent='" + intent + '\'' +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
