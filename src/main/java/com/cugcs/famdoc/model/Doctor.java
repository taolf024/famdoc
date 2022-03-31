package com.cugcs.famdoc.model;

import java.util.Date;

public class Doctor {
    public void setUsername(String username) {
        this.username = username;
    }

    private Integer doc_id;
    private String username;
    private String doc_name;
    private String doc_birth;
    private String doc_sex;
    private String doc_tel;
    private String doc_idnum;

    @Override
    public String toString() {
        return "Doctor{" +
                "doc_id=" + doc_id +
                ", username=" + username +
                ", doc_name='" + doc_name + '\'' +
                ", doc_birth=" + doc_birth +
                ", doc_sex='" + doc_sex + '\'' +
                ", doc_tel='" + doc_tel + '\'' +
                ", doc_idnum='" + doc_idnum + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getDoc_birth() {
        return doc_birth;
    }

    public void setDoc_birth(String doc_birth) {
        this.doc_birth = doc_birth;
    }

    public Integer getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }


    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_sex() {
        return doc_sex;
    }

    public void setDoc_sex(String doc_sex) {
        this.doc_sex = doc_sex;
    }

    public String getDoc_tel() {
        return doc_tel;
    }

    public void setDoc_tel(String doc_tel) {
        this.doc_tel = doc_tel;
    }

    public String getDoc_idnum() {
        return doc_idnum;
    }

    public void setDoc_idnum(String doc_idnum) {
        this.doc_idnum = doc_idnum;
    }
}
