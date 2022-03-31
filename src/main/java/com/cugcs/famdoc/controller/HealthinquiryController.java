package com.cugcs.famdoc.controller;

import com.cugcs.famdoc.converter.DateConverter;
import com.cugcs.famdoc.mapper.MessageMapper;
import com.cugcs.famdoc.model.HealthData;
import com.cugcs.famdoc.model.Patient;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.MessageService;
import com.cugcs.famdoc.service.PatientService;
import com.cugcs.famdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 通知页面
 */
@Controller
public class HealthinquiryController {
    @Autowired
    MessageService messageService;
    @Autowired
    PatientService patientService;

    @RequestMapping("/healthinquiry")
    public String healthinquiry(Model model, HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient patient =patientService.loadPatByUser(username);
        model.addAttribute("infs",messageService.getAllMessage(patient.getPatient_id()));
        return "healthinquiry";
    }
    @RequestMapping("/submessage")
    public String submessage(String message ,HttpSession httpSession) throws ParseException {
        //有关时间
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat formatter2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Random rand = new Random();
        String id =formatter.format(date)+rand.nextInt(9)+rand.nextInt(9)+rand.nextInt(9);
        String time = formatter2.format(date);
        Date date1 = formatter2.parse(time);
        //有关操作
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient patient =patientService.loadPatByUser(username);
        messageService.addMessage( message , id , patient.getPatient_id() ,patient.getPatient_name(), date1, patient.getDoc_id());
        System.out.println(id);
        System.out.println(patient.getPatient_id());
        System.out.println(date);
        return "redirect:/healthinquiry";
    }

}
