package com.cugcs.famdoc.controller;

import com.cugcs.famdoc.model.*;
import com.cugcs.famdoc.service.DoctorService;
import com.cugcs.famdoc.service.MessageService;
import com.cugcs.famdoc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 通知页面
 */
@Controller
public class HealthinquiryDocController {
    //一页放10条数据
    public static final Integer PAGE_SIZE = 10;

    @Autowired
    MessageService messageService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;

/*    @RequestMapping("/healthinquirydoc")
    public String healthinquirydoc(Model model, HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doc = doctorService.loadDocByUser(username);
        model.addAttribute("dinfs",messageService.getAllMessageBydoc(doc.getDoc_id()));
        return "healthinquirydoc";
    }*/

    @RequestMapping("/healthinquirydoc")
    public String healthinquirydoc(String kong,@RequestParam(defaultValue = "1")Integer page, Model model, HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doc = doctorService.loadDocByUser(username);
        List<Message> mess = messageService.getMessByPatAndDoc(kong,doc.getDoc_id(),page,PAGE_SIZE);

        Long total = messageService.getTotal(kong,doc.getDoc_id());
        model.addAttribute("dinfs", mess);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pagenum",
                total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1);
        return "/healthinquirydoc";
    }

    @RequestMapping("/replypat")
    public String reply(String messageId , Model model) {
        Message mess = messageService.getMessageByid(messageId);
        model.addAttribute("cms",mess);
        return "replypat";
    }

    @RequestMapping("/doreply")
    public String doreply(String messageId ,String reply, HttpSession httpSession) throws ParseException {
        //有关时间
        SimpleDateFormat formatter2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter2.format(date);
        Date date1 = formatter2.parse(time);

        messageService.replyPat(messageId,date1,reply);
        return "redirect:/healthinquirydoc";
    }
}
