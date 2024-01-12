package com.example.zhangshangmeishibao.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    private int id;
    private String comment;
    @Column(name = "uploadtime")
    private String upload_time;
    private String username;
    private int healthy_diet_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHealthy_diet_id() {
        return healthy_diet_id;
    }

    public void setHealthy_diet_id(int healthy_diet_id) {
        this.healthy_diet_id = healthy_diet_id;
    }
}
