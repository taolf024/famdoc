package com.cugcs.famdoc.mapper;

import com.cugcs.famdoc.model.PatInf;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface PatInfMapper {
    Long selectLprsNum(@Param("doc_id") Integer doc_id,
                       @Param("date") Date date);

    Long selectHprsNum(@Param("doc_id") Integer doc_id,
                       @Param("date") Date date);

    Long selectOwNum(@Param("doc_id") Integer doc_id,
                     @Param("date") Date date);

    void addNewData(@Param("pid") Integer patient_id,
                    @Param("did") Integer doc_id,
                    @Param("hb") Integer hbloodprs,
                    @Param("lb") Integer lbloodprs,
                    @Param("weight") Double weight,
                    @Param("today") Date date1);

    PatInf loadToday(@Param("patientid")Integer patientid,
                     @Param("date")Date date1);
}
