package com.cugcs.famdoc.controller;

import com.cugcs.famdoc.mapper.PatInfMapper;
import com.cugcs.famdoc.model.HealthData;
import com.cugcs.famdoc.model.Patient;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.HealthDataService;
import com.cugcs.famdoc.service.PatInfService;
import com.cugcs.famdoc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PersonHealthController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private HealthDataService healthDataService;
    @Autowired
    private PatInfService patInfService;

    //患者端 个人健康档案页面
    @RequestMapping("/personhealth")
    public String personhealth(Model model,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient patient = patientService.loadPatByUser(username);
        model.addAttribute("healths",healthDataService.getAllHealthById(patient.getPatient_id()));
        return "personhealth";
    }

    //患者端 修改健康信息页面
    @RequestMapping("/changehealth")
    public String changehealth(HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();

        Patient patient = patientService.loadPatByUser(username);
        HealthData healthData = healthDataService.loadHealthByPatId(patient.getPatient_id());
        httpSession.setAttribute("currentPatHeal", healthData);
        return "changehealth";
    }

    //患者端 进行修改健康信息
    @RequestMapping("/changeheal")
    public String changehealthdata( Double height, Double weight,String allergy ,Integer hbloodprs,Integer lbloodprs,String pastmedicalhistory,String other,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient patient = patientService.loadPatByUser(username);
        healthDataService.changeheal(patient.getPatient_id(), height , weight , allergy ,hbloodprs ,lbloodprs , pastmedicalhistory , other);
        return "redirect:/personhealth";
    }

    //患者端 提交当日信息页面
    @RequestMapping("/submithealth")
    public String submithealth(HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient patient = patientService.loadPatByUser(username);
        httpSession.setAttribute("currentPatname", patient.getPatient_name());
        return "submithealth";
    }

    //患者端 提交当日健康信息
    @RequestMapping("/subheal")
    public String subheal(Double weight,Integer hbloodprs,Integer lbloodprs,HttpSession httpSession) throws ParseException {
        //时间相关
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        Date date1 = formatter.parse(time);
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient patient = patientService.loadPatByUser(username);
        patInfService.addNewData(patient.getPatient_id(),patient.getDoc_id(),hbloodprs,lbloodprs,weight,date1);
        healthDataService.updateDate(patient.getPatient_id(),weight,hbloodprs,lbloodprs);
        return "redirect:/personhealth";
    }

}
