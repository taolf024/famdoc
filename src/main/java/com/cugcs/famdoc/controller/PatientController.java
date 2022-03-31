package com.cugcs.famdoc.controller;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.Patient;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.DoctorService;
import com.cugcs.famdoc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/patients")
    public String patients(Model model,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        model.addAttribute("pats",patientService.getAllPat(username));
        Patient patient = patientService.loadPatByUser(username);
        if(patient.getDoc_id()!=null){
            Doctor doctor = doctorService.getDocById(patient.getDoc_id());
            model.addAttribute("yourdoc",doctor.getDoc_name());
        }

        return "patients";
    }

    @RequestMapping("/changepatient")
    public String changepatien(HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Patient patient = patientService.loadPatByUser(username);
        httpSession.setAttribute("currentPatient", patient);
        return "changepatient";
    }


    @RequestMapping("/changepat")
    public String changepat( String name, String birth,String sex ,String add,String tel,String idnum,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        patientService.changepat(username, name , birth , sex ,add , tel , idnum);
        return "redirect:/patients";
    }
}
