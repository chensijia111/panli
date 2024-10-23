package com.cn.fms.pojo;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private String content;
    private String image;
    private String publisher;
    private Date createTime = new Date();

    public News() {
    }

    public News(int id, String title, String content, String image, String publisher, Date createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.publisher = publisher;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", publisher='" + publisher + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
