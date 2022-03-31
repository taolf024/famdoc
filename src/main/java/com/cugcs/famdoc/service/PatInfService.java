package com.cugcs.famdoc.service;

import com.cugcs.famdoc.mapper.HealthDataMapper;
import com.cugcs.famdoc.mapper.PatInfMapper;
import com.cugcs.famdoc.model.PatInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PatInfService {
    @Autowired
    PatInfMapper patInfMapper;


    public Long selectLprsNum(Integer doc_id, Date date) {
        return  patInfMapper.selectLprsNum(doc_id,date);
    }

    public Long selectHprsNum(Integer doc_id, Date date) {
        return  patInfMapper.selectHprsNum(doc_id,date);
    }

    public Long selectOwNum(Integer doc_id, Date date) {
        return  patInfMapper.selectOwNum(doc_id,date);
    }

    public void addNewData(Integer patient_id, Integer doc_id, Integer hbloodprs, Integer lbloodprs, Double weight, Date date1) {
        patInfMapper.addNewData(patient_id,doc_id, hbloodprs,lbloodprs,weight, date1);
    }

    public PatInf loadToday(Integer patientid, Date date1) {
        return patInfMapper.loadToday(patientid, date1);
    }

    public PatInf loadbefor1(Integer patientid, Date dateBefore) {
        return patInfMapper.loadToday(patientid, dateBefore);
    }

    public PatInf loadbefor2(Integer patientid, Date dateBefore) {
        return patInfMapper.loadToday(patientid, dateBefore);
    }

    public PatInf loadbefor3(Integer patientid, Date dateBefore) {
        return patInfMapper.loadToday(patientid, dateBefore);
    }

    public PatInf loadbefor4(Integer patientid, Date dateBefore) {
        return patInfMapper.loadToday(patientid, dateBefore);
    }

    public PatInf loadbefor5(Integer patientid, Date dateBefore) {
        return patInfMapper.loadToday(patientid, dateBefore);
    }

    public PatInf loadbefor6(Integer patientid, Date dateBefore) {
        return patInfMapper.loadToday(patientid, dateBefore);
    }
}
