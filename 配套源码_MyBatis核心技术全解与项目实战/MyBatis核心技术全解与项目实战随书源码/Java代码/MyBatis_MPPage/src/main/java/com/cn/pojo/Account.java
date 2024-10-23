package com.cn.pojo;

import com.baomidou.mybatisplus.annotation.*;

@TableName("t_account")
public class Account {
    @TableId(value = "a_id",type = IdType.AUTO)
    private Long id;
    @TableField("a_name")
    private String name;
    @TableField("a_money")
    private int money;
    @Version
    @TableField("a_version")
    private int version;

    public Account() {
    }

    public Account(Long id, String name, int money, int version) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", version=" + version +
                '}';
    }
}
