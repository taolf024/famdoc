package com.cugcs.famdoc.mapper;

import com.cugcs.famdoc.model.Visit;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface VisitMapper {
    void addNewVisit(@Param("pid") Integer patid,
                     @Param("pname") String name,
                     @Param("did") Integer doc_id,
                     @Param("time") String time);

    List<Visit> getvisit(@Param("did") Integer doc_id,
                         @Param("time") String visittime);

    List<Visit> getvisitbypid(@Param("pid") Integer patient_id,
                              @Param("time") String visittime);
}
