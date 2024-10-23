package com.cn.mpg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 谷哥的小弟
 * @since 2023-01-28
 */
@TableName("t_doctor")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "d_id", type = IdType.AUTO)
    private Long dId;

    private String dName;

    private String dGender;

    private Integer dAge;

    private Integer status;

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
    public String getdGender() {
        return dGender;
    }

    public void setdGender(String dGender) {
        this.dGender = dGender;
    }
    public Integer getdAge() {
        return dAge;
    }

    public void setdAge(Integer dAge) {
        this.dAge = dAge;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Doctor{" +
            "dId=" + dId +
            ", dName=" + dName +
            ", dGender=" + dGender +
            ", dAge=" + dAge +
            ", status=" + status +
        "}";
    }
}
