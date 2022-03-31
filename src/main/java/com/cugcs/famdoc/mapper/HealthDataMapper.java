package com.cugcs.famdoc.mapper;


import com.cugcs.famdoc.model.HealthData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HealthDataMapper {

    void AddPatIdIntoHealth(Integer patientid);

    HealthData loadHealthByPatId(Integer patientid);

    List<HealthData> getAllHealthById(Integer patientid);

    void changeheal(@Param("patient_id")Integer patient_id,
                    @Param("height")Double height,
                    @Param("weight")Double weight,
                    @Param("allergy")String allergy,
                    @Param("hbloodprs")Integer hbloodprs,
                    @Param("lbloodprs")Integer lbloodprs,
                    @Param("pastmedicalhistory")String pastmedicalhistory,
                    @Param("other")String other);

    void updateDate(@Param("pid")Integer patient_id,
                    @Param("w")Double weight,
                    @Param("hb")Integer hbloodprs,
                    @Param("lb")Integer lbloodprs);

//    void updateDate(@Param("patient_id")Integer patient_id,
//                    @Param("w") Double weight,
//                    @Param("hb") Integer hbloodprs,
//                    @Param("lb") Integer lbloodprs);
}
