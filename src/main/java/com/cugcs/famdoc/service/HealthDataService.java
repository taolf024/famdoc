package com.cugcs.famdoc.service;

import com.cugcs.famdoc.mapper.HealthDataMapper;
import com.cugcs.famdoc.mapper.PatientMapper;
import com.cugcs.famdoc.model.HealthData;
import com.cugcs.famdoc.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthDataService {
    @Autowired
    HealthDataMapper healthDataMapper;


    public void AddPatIdIntoHealth(Integer patientid) {
        healthDataMapper.AddPatIdIntoHealth(patientid);
    }

    public HealthData loadHealthByPatId(Integer patientid) {
        HealthData healthData = healthDataMapper.loadHealthByPatId(patientid);
        return healthData;
    }

    public List<HealthData> getAllHealthById(Integer patientid) {
        return healthDataMapper.getAllHealthById(patientid);
    }

    public void changeheal(Integer patient_id, Double height, Double weight, String allergy, Integer hbloodprs, Integer lbloodprs,String pastmedicalhistory, String other) {
        healthDataMapper.changeheal(patient_id,height,weight,allergy,hbloodprs,lbloodprs,pastmedicalhistory,other);
    }

    public void updateDate(Integer patient_id, Double weight, Integer hbloodprs, Integer lbloodprs) {
         healthDataMapper.updateDate(patient_id,weight,hbloodprs, lbloodprs);
    }

//    public void updateDate(Integer patient_id,Double weight, Integer hbloodprs, Integer lbloodprs) {
//        healthDataMapper.updateDate(patient_id,weight,hbloodprs, lbloodprs);
//    }
}
