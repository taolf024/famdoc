package com.cugcs.famdoc.model;

import java.util.Date;

public class Visit {
    private Integer visit_id;
    private Integer patient_id;
    private String patient_name;
    private Integer doc_id;

    public Visit(Integer visit_id, Integer patient_id, String patient_name, Integer doc_id, String visit_time) {
        this.visit_id = visit_id;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.doc_id = doc_id;
        this.visit_time = visit_time;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    private String visit_time;


    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getDoc_id() {
        return doc_id;
    }

    public String getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(String visit_time) {
        this.visit_time = visit_time;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }



    public Visit() {
    }


}
