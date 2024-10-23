package com.cn.fms.pojo;

public class InvestorDto {
    private String name = "";
    private String levelID = "";
    private String fieldID = "";
    private String intentID = "";

    public InvestorDto() {
    }

    public InvestorDto(String name, String levelID, String fieldID, String intentID) {
        this.name = name;
        this.levelID = levelID;
        this.fieldID = fieldID;
        this.intentID = intentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelID() {
        return levelID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
    }

    public String getFieldID() {
        return fieldID;
    }

    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }

    public String getIntentID() {
        return intentID;
    }

    public void setIntentID(String intentID) {
        this.intentID = intentID;
    }
}
