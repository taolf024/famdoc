package com.cugcs.famdoc.service;

import com.cugcs.famdoc.mapper.PatientMapper;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;

    public List<Patient> getAllPat(String username) {
        return patientMapper.getAllPat(username);
    }

    public Integer doReg(String username, String name, String sex, String tel, String idnum) {
        return patientMapper.doReg(username,name,sex,tel,idnum);
    }

    public Patient loadPatByUser(String username) {
        Patient patient = patientMapper.loadPatByUser(username);
        return patient;
    }

    public void changepat(String currentuser, String name, String birth, String sex, String add, String tel, String idnum) {
        patientMapper.changepat(currentuser,name,birth,sex,add,tel,idnum);
    }

    //分页查询获得所有Pats
    public List<Patient> getAllPat2(String name,String tel,Integer docid, Integer page, Integer pageSize) {
        //这个page是从第几行数据开始查
        page = (page - 1) * pageSize;
        return patientMapper.getAllPat2(name,tel,docid, page, pageSize);
    }

    public Long getTotal(String name,String tel,Integer docid) {
        return patientMapper.getTotal(name,tel,docid);
    }

    public List<Patient> getAllPat3(String name, String idnum, Integer page, Integer pageSize) {
        //这个page是从第几行数据开始查
        page = (page - 1) * pageSize;
        return patientMapper.getAllPat3(name, idnum, page, pageSize);
    }

    public Long getTotal3(String name, String idnum) {
        return patientMapper.getTotal3(name,idnum);
    }

    public Patient getPatientById(Integer patientid) {
        return patientMapper.getPatientById(patientid);
    }

    public void addDocToPat(Integer patientid, Integer doc_id) {
        patientMapper.addDocToPat(patientid, doc_id);
    }
}
