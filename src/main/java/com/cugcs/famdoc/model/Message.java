package com.cugcs.famdoc.model;


import java.util.Date;

public class Message {
    private String message_id;
    private String patient_name;

    public Message(String message_id, String patient_name, Integer patient_id, String message_user, Date message_usertime, Integer doc_id, String message_doc, Date message_doctime) {
        this.message_id = message_id;
        this.patient_name = patient_name;
        this.patient_id = patient_id;
        this.message_user = message_user;
        this.message_usertime = message_usertime;
        this.doc_id = doc_id;
        this.message_doc = message_doc;
        this.message_doctime = message_doctime;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public Message() {
    }


    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getMessage_user() {
        return message_user;
    }

    public void setMessage_user(String message_user) {
        this.message_user = message_user;
    }

    public Date getMessage_usertime() {
        return message_usertime;
    }

    public void setMessage_usertime(Date message_usertime) {
        this.message_usertime = message_usertime;
    }

    public Integer getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }

    public String getMessage_doc() {
        return message_doc;
    }

    public void setMessage_doc(String message_doc) {
        this.message_doc = message_doc;
    }

    public Date getMessage_doctime() {
        return message_doctime;
    }

    public void setMessage_doctime(Date message_doctime) {
        this.message_doctime = message_doctime;
    }

    private Integer patient_id;
    private String message_user;
    private Date message_usertime;
    private Integer doc_id;

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    private String message_doc;
    private Date message_doctime;
}
