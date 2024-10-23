package com.cn.pojo;

public class Worker {
    private Integer wId;

    private String wName;

    private Integer fId;

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName == null ? null : wName.trim();
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "wId=" + wId +
                ", wName='" + wName + '\'' +
                ", fId=" + fId +
                '}';
    }
}