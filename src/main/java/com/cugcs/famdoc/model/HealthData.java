package com.cugcs.famdoc.model;

public class HealthData {
    private Integer patient_id;
    private Double height;
    private Double weight;
    private String allergy;
    private Integer hbloodprs;
    private Integer lbloodprs;
    private String pastmedicalhistory;

    public HealthData(Integer patient_id, Double height, Double weight, String allergy, Integer hbloodprs, Integer lbloodprs, String pastmedicalhistory, String other) {
        this.patient_id = patient_id;
        this.height = height;
        this.weight = weight;
        this.allergy = allergy;
        this.hbloodprs = hbloodprs;
        this.lbloodprs = lbloodprs;
        this.pastmedicalhistory = pastmedicalhistory;
        this.other = other;
    }

    private String other;

    public Integer getHbloodprs() {
        return hbloodprs;
    }

    public void setHbloodprs(Integer hbloodprs) {
        this.hbloodprs = hbloodprs;
    }

    public Integer getLbloodprs() {
        return lbloodprs;
    }

    public void setLbloodprs(Integer lbloodprs) {
        this.lbloodprs = lbloodprs;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }


    public String getPastmedicalhistory() {
        return pastmedicalhistory;
    }

    public void setPastmedicalhistory(String pastmedicalhistory) {
        this.pastmedicalhistory = pastmedicalhistory;
    }
}
