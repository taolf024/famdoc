package com.cugcs.famdoc.service;

import com.cugcs.famdoc.mapper.DoctorMapper;
import com.cugcs.famdoc.mapper.MessageMapper;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageMapper messageMapper;

    public List<Message> getAllMessage(Integer patient_id) {
        return messageMapper.getAllMessage(patient_id);
    }

    public void addMessage(String message, String id, Integer patient_id, String patient_name,Date date, Integer doc_id) {
        messageMapper.addMessage(message, id, patient_id ,patient_name, date , doc_id);
    }

    public List<Message> getMessByPatAndDoc(String kong,Integer doc_id, Integer page, Integer pageSize) {
        //这个page是从第几行数据开始查
        page = (page - 1) * pageSize;
        return messageMapper.getMessByPatAndDoc(kong,doc_id, page, pageSize);
    }

    public Long getTotal(String kong,Integer doc_id) {
        return messageMapper.getTotal(kong,doc_id);
    }

    public List<Message> getAllMessageBydoc(Integer doc_id) {
            return messageMapper.getAllMessageBydoc(doc_id);
    }

    public Message getMessageByid(String messageid) {
        return messageMapper.getMessageByid(messageid);
    }

    public void replyPat(String messageId,Date date, String reply) {
        messageMapper.addMessageById(messageId,date,reply);
    }
}
