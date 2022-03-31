package com.cugcs.famdoc.controller;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.PatInf;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.DoctorService;
import com.cugcs.famdoc.service.PatInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class PatHealthViewController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatInfService patInfService;


    @RequestMapping("/pathealthview")
    public String patientview(Integer patientid,HttpSession httpSession,Model model) throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        Date date1 = formatter.parse(time);

        PatInf patInftoday = patInfService.loadToday(patientid,date1);
        model.addAttribute("todayInf",patInftoday);
        PatInf patInfbefor1 = patInfService.loadbefor1(patientid,getDateBefore(date1,1));
        model.addAttribute("befor1Inf",patInfbefor1);
        PatInf patInfbefor2 = patInfService.loadbefor2(patientid,getDateBefore(date1,2));
        model.addAttribute("befor2Inf",patInfbefor2);
        PatInf patInfbefor3 = patInfService.loadbefor3(patientid,getDateBefore(date1,3));
        model.addAttribute("befor3Inf",patInfbefor3);
        PatInf patInfbefor4 = patInfService.loadbefor4(patientid,getDateBefore(date1,4));
        model.addAttribute("befor4Inf",patInfbefor4);
        PatInf patInfbefor5 = patInfService.loadbefor5(patientid,getDateBefore(date1,5));
        model.addAttribute("befor5Inf",patInfbefor5);
        PatInf patInfbefor6 = patInfService.loadbefor6(patientid,getDateBefore(date1,6));
        model.addAttribute("befor6Inf",patInfbefor6);
        return "pathealthview";
    }

    public static Date getDateBefore(Date d,int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
        return now.getTime();
    }

}
