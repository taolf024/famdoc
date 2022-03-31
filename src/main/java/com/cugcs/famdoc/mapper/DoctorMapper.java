package com.cugcs.famdoc.mapper;

import com.cugcs.famdoc.model.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorMapper {

    List<Doctor> getAllDoc(String Username);

    Integer doReg(@Param("username") String username,@Param("doc_name")String name,@Param("doc_sex")String sex,@Param("doc_tel")String tel,@Param("doc_idnum")String idnum);

    void changedoc(@Param("username")String currentuser, @Param("doc_name")String name, @Param("doc_birth")String birth,@Param("doc_sex") String sex, @Param("doc_tel")String tel, @Param("doc_idnum")String idnum);

    Doctor loadDocByUser(String currentuser);

    Doctor getDocById(Integer doc_id);

}
