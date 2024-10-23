package com.cn.pojo;

public class Customer {
    private Integer cId;
    private String cName;
    private Integer cAge;

    public Customer() {
    }

    public Customer(Integer cId, String cName, Integer cAge) {
        this.cId = cId;
        this.cName = cName;
        this.cAge = cAge;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcAge() {
        return cAge;
    }

    public void setcAge(Integer cAge) {
        this.cAge = cAge;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cAge=" + cAge +
                '}';
    }
}
