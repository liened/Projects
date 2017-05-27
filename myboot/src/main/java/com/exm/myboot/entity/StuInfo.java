package com.exm.myboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="STU_INFO")
public class StuInfo implements Serializable{

    @Id
    @Column(nullable = false,unique = true)
    private String stdId;

    @Column(nullable = false,unique = false)
    private String stuName;

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}