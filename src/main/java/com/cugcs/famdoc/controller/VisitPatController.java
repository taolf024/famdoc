package com.cugcs.famdoc.controller;

import com.cugcs.famdoc.model.*;
import com.cugcs.famdoc.service.DoctorService;
import com.cugcs.famdoc.service.HealthDataService;
import com.cugcs.famdoc.service.PatientService;
import com.cugcs.famdoc.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VisitPatController {
    //一页放10条数据
    public static final Integer PAGE_SIZE = 10;

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private HealthDataService healthDataService;
    @Autowired
    private VisitService visitService;


    //家访管理
    @RequestMapping("/visitpat")
    public String visitpat(String visittime, Model model, HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient pat = patientService.loadPatByUser(username);
        if(pat.getDoc_id()!=null){
            Doctor doctor = doctorService.getDocById(pat.getDoc_id());
            model.addAttribute("yourdoc",doctor.getDoc_name());
        }
        List<Visit>  visits = visitService.getvisitbypid(pat.getPatient_id(),visittime);
        model.addAttribute("pvisits",visits);

        return "visitpat";
    }

}
