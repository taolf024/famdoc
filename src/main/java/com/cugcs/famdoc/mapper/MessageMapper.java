package com.cugcs.famdoc.mapper;

import com.cugcs.famdoc.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MessageMapper {
    List<Message> getAllMessage(Integer patient_id);


    void addMessage(@Param("message_user") String message,
                    @Param("message_id")String id,
                    @Param("patient_id")Integer patient_id,
                    @Param("patient_name")String patient_name,
                    @Param("message_usertime")Date date,
                    @Param("doc_id")Integer doc_id);

    List<Message> getMessByPatAndDoc(@Param("kong")String kong,
                                     @Param("doc_id")Integer doc_id,
                                     @Param("page")Integer page,
                                     @Param("pagesize")Integer pageSize);

    Long getTotal(@Param("kong")String kong,
                  @Param("doc_id")Integer doc_id
    );

    List<Message> getAllMessageBydoc(Integer doc_id);

    Message getMessageByid(String messageid);

    void addMessageById(@Param("messageid") String messageId,
                        @Param("doctime")Date date,
                        @Param("reply") String reply);
}
