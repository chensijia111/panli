package com.cn.pojo;

public class City {
    private Integer cId;
    private String cName;
    private Integer pId;

    public City() {
    }

    public City(Integer cId, String cName, Integer pId) {
        this.cId = cId;
        this.cName = cName;
        this.pId = pId;
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "City{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", pId=" + pId +
                '}';
    }
}
