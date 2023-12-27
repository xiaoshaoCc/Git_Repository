package com.example.zhangshangmeishibao.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class School {

    @Id
    private String school_id;
    private String school_name;

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
}
