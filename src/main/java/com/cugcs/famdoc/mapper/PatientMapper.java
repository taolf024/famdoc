package com.cugcs.famdoc.mapper;

import com.cugcs.famdoc.model.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {

    List<Patient> getAllPat(String username);

    Integer doReg(@Param("username") String username, @Param("patient_name")String name, @Param("patient_sex")String sex, @Param("patient_tel")String tel, @Param("patient_idnum")String idnum);

    Patient loadPatByUser(String username);

    void changepat(@Param("username")String currentuser, @Param("patient_name")String name, @Param("patient_birth")String birth, @Param("patient_sex")String sex,@Param("patient_add") String add,@Param("patient_tel") String tel,@Param("patient_idnum") String idnum);


    List<Patient> getAllPat2(@Param("patient_name")String name,
                             @Param("patient_tel")String tel,
                             @Param("docid") Integer docid,
                             @Param("page") Integer page,
                             @Param("pagesize") Integer pageSize);

    Long getTotal(@Param("patient_name")String name,
                  @Param("patient_tel")String tel,
                  @Param("docid") Integer docid);

    List<Patient> getAllPat3(@Param("patient_name")String name,
                             @Param("patient_idnum")String idnum,
                             @Param("page")Integer page,
                             @Param("pagesize")Integer pageSize);

    Long getTotal3(@Param("patient_name")String name,
                   @Param("patient_idnum")String idnum);

    Patient getPatientById(Integer patientid);

    void addDocToPat(@Param("patientid")Integer patientid,
                     @Param("doc_id")Integer doc_id);
}
