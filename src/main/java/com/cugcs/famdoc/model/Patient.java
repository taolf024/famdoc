package com.cugcs.famdoc.model;

import java.util.Date;

public class Patient {
    private Integer patient_id;
    private String username;
    private String patient_name;
    private String patient_birth;

    public String getPatient_birth() {
        return patient_birth;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", username='" + username + '\'' +
                ", patient_name='" + patient_name + '\'' +
                ", patient_birth='" + patient_birth + '\'' +
                ", patient_sex='" + patient_sex + '\'' +
                ", patient_tel='" + patient_tel + '\'' +
                ", patient_add='" + patient_add + '\'' +
                ", patient_idnum='" + patient_idnum + '\'' +
                ", doc_id=" + doc_id +
                '}';
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getUsername() {
        return username;
    }

    public void setPatient_birth(String patient_birth) {
        this.patient_birth = patient_birth;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }


    public String getPatient_sex() {
        return patient_sex;
    }

    public void setPatient_sex(String patient_sex) {
        this.patient_sex = patient_sex;
    }

    public String getPatient_tel() {
        return patient_tel;
    }

    public void setPatient_tel(String patient_tel) {
        this.patient_tel = patient_tel;
    }

    public String getPatient_add() {
        return patient_add;
    }

    public void setPatient_add(String patient_add) {
        this.patient_add = patient_add;
    }

    public String getPatient_idnum() {
        return patient_idnum;
    }

    public void setPatient_idnum(String patient_idnum) {
        this.patient_idnum = patient_idnum;
    }

    public Integer getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }

    private String patient_sex;
    private String patient_tel;
    private String patient_add;
    private String patient_idnum;
    private Integer doc_id;
}
