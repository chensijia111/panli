package com.cn.pojo;

public class Job {
    private Integer id;
    private String name;
    private Integer count;
    private String education;
    private String exp;
    private String kind;
    private Integer product;
    private String property;
    private String adress;
    public Job(){

    }

    public Job(Integer id, String name, Integer count, String education, String exp, String kind, Integer product, String property, String adress) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.education = education;
        this.exp = exp;
        this.kind = kind;
        this.product = product;
        this.property = property;
        this.adress = adress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", education='" + education + '\'' +
                ", exp='" + exp + '\'' +
                ", kind='" + kind + '\'' +
                ", product=" + product +
                ", property='" + property + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
