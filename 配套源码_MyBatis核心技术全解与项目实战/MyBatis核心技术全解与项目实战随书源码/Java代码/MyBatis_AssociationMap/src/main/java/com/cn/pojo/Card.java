package com.cn.pojo;

public class Card {
    private Integer id;
    private String number;

    public Card() {
    }

    public Card(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
