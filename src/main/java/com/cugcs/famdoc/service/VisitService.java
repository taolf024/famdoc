package com.cugcs.famdoc.service;

import com.cugcs.famdoc.mapper.DoctorMapper;
import com.cugcs.famdoc.mapper.VisitMapper;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VisitService {
    @Autowired
    VisitMapper visitMapper;

    public void addNewVisit(Integer patid, String name, Integer doc_id,String time) {
        visitMapper.addNewVisit(patid, name, doc_id,time);
    }

    public List<Visit> getvisit(Integer doc_id, String visittime) {
        return visitMapper.getvisit(doc_id,visittime);
    }

    public List<Visit> getvisitbypid(Integer patient_id, String visittime) {
        return visitMapper.getvisitbypid(patient_id,visittime);
    }
}
