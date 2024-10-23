package com.cn.pojo;

import java.util.List;

public class Province {
    private Integer pId;
    private String pName;
    private List<City> cityList;

    public Province() {
    }

    public Province(Integer pId, String pName, List<City> cityList) {
        this.pId = pId;
        this.pName = pName;
        this.cityList = cityList;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "Province{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", cityList=" + cityList +
                '}';
    }
}
