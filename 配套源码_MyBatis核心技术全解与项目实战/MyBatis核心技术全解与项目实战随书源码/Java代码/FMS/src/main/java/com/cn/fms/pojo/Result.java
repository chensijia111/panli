package com.cn.fms.pojo;

import com.cn.fms.utils.Constants;

// 封装AJAX操作的结果
public class Result {
    private String status = Constants.OK;
    private String description;
    private Object data;

    public Result() {
    }

    public Result(String status, String description, Object data) {
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", data=" + data +
                '}';
    }
}
