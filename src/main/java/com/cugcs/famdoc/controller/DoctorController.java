package com.cugcs.famdoc.controller;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/doctors")
    public String doctors(Model model,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        model.addAttribute("docs",doctorService.getAllDoc(username));
        return "doctors";
    }

    @RequestMapping("/changedoctor")
    public String changedoctorhtml(HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doctor = doctorService.loadDocByUser(username);
        httpSession.setAttribute("currentDoctor", doctor);
        return "changedoctor";
    }


    @RequestMapping("/changedoc")
    public String changedoc( String name, String birth,String sex ,String tel,String idnum,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        doctorService.changedoc(username, name , birth , sex , tel , idnum);
        return "redirect:/doctors";
    }
}
