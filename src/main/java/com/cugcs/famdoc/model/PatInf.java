package com.cugcs.famdoc.model;
import java.util.Date;

public class PatInf {
    private Integer patinfId;
    private Integer patient_id;

    public Date getDaytime() {
        return daytime;
    }

    public void setDaytime(Date daytime) {
        this.daytime = daytime;
    }

    public PatInf(Integer patinfId, Integer patient_id, Integer doc_id, Integer hprs, Integer lprs, Double weight, Date daytime) {
        this.patinfId = patinfId;
        this.patient_id = patient_id;
        this.doc_id = doc_id;
        this.hprs = hprs;
        this.lprs = lprs;
        this.weight = weight;
        this.daytime = daytime;
    }

    public Integer getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(Integer doc_id) {
        this.doc_id = doc_id;
    }

    private Integer doc_id;
    private Integer hprs;
    private Integer lprs;
    private Double weight;
    private Date daytime;

    public Integer getPatinfId() {
        return patinfId;
    }

    public void setPatinfId(Integer patinfId) {
        this.patinfId = patinfId;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getHprs() {
        return hprs;
    }

    public void setHprs(Integer hprs) {
        this.hprs = hprs;
    }

    public Integer getLprs() {
        return lprs;
    }

    public void setLprs(Integer lprs) {
        this.lprs = lprs;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public PatInf() {
    }
}
