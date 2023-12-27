package com.example.zhangshangmeishibao.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    private String id;
    private String password;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
