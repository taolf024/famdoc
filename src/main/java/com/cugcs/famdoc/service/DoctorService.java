package com.cugcs.famdoc.service;

import com.cugcs.famdoc.mapper.DoctorMapper;
import com.cugcs.famdoc.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorMapper doctorMapper;

    public List<Doctor> getAllDoc(String username) {
        return doctorMapper.getAllDoc(username);
    }

    public Integer doReg(String username,String name,String sex,String tel,String idnum) {
        return doctorMapper.doReg(username,name,sex,tel,idnum);
    }


    public void changedoc(String currentuser, String name, String birth, String sex, String tel, String idnum) {
        doctorMapper.changedoc(currentuser,name,birth,sex,tel,idnum);
    }

    public Doctor loadDocByUser(String currentuser) {
        Doctor doctor = doctorMapper.loadDocByUser(currentuser);
        return doctor;
    }

    public Doctor getDocById(Integer doc_id) {
        return doctorMapper.getDocById(doc_id);
    }
}
