package com.cn.fms.pojo;

public class Dictionary {
    private int id;
    private int code;
    private String type;
    private String description;

    public Dictionary() {
    }

    public Dictionary(int id, int code, String type, String description) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", code=" + code +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
