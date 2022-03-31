package com.cugcs.famdoc.controller;

import com.cugcs.famdoc.mapper.HealthDataMapper;
import com.cugcs.famdoc.mapper.VisitMapper;
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
import java.util.Date;
import java.util.List;

@Controller
public class DocCtrlPatController {
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


    //签约患者
    @RequestMapping("/addpatient")
    public String addpatient(String name,String idnum,@RequestParam(defaultValue = "1")Integer page,Model model) {
        List<Patient> pats = patientService.getAllPat3(name,idnum, page, PAGE_SIZE);

        Long total = patientService.getTotal3(name,idnum);
        model.addAttribute("pats", pats);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pagenum",
                total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1);
        return "addpatient";
    }

    //搜索自己的患者
    @RequestMapping("/searchpatient")
    public String searchpatient(String name, String tel, @RequestParam(defaultValue = "1")Integer page, Model model, HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doc = doctorService.loadDocByUser(username);
        List<Patient> pats = patientService.getAllPat2(name,tel,doc.getDoc_id(), page, PAGE_SIZE);
        model.addAttribute("yourself",doc.getDoc_name());
        Long total = patientService.getTotal(name,tel,doc.getDoc_id());
        model.addAttribute("pats", pats);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pagenum",
                total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1);
        return "searchpatient";
    }

    //某患者的详细信息
    @RequestMapping("/patienthealthdetail")
    public String patienthealthdetail(Integer patientid , Model model) {
        Patient patient = patientService.getPatientById(patientid);
        model.addAttribute("patient",patient);
        HealthData healthData = healthDataService.loadHealthByPatId(patientid);
        model.addAttribute("Heal",healthData);
        return "patienthealthdetail";
    }

    @RequestMapping("/addpat")
    public String addpat(Integer patientid,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doctor = doctorService.loadDocByUser(username);
        patientService.addDocToPat(patientid,doctor.getDoc_id());
        return "redirect:/addpatient";
    }

    //家访管理
    @RequestMapping("/visit")
    public String visit(String visittime, @RequestParam(defaultValue = "1")Integer page, Model model, HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doc = doctorService.loadDocByUser(username);
        List<Visit>  visits = visitService.getvisit(doc.getDoc_id(),visittime);
        model.addAttribute("dvisits",visits);
/*        Long total = patientService.getTotal(name,tel,doc.getDoc_id());*/
/*        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pagenum",
                total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1);*/
        return "visit";
    }

    //某患者的详细信息
    @RequestMapping("/visitdetail")
    public String visitdetail(Integer patientid , Model model) {
        Patient patient = patientService.getPatientById(patientid);
        model.addAttribute("patient",patient);
        return "visitdetail";
    }

    @RequestMapping("/dovisit")
    public String dovisit(Integer patid,String name ,String time,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doctor = doctorService.loadDocByUser(username);
        visitService.addNewVisit(patid,name,doctor.getDoc_id(),time);
        return "redirect:/searchpatient";
    }
}
