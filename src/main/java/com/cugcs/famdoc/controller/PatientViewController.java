package com.cugcs.famdoc.controller;
import com.cugcs.famdoc.model.Doctor;
import com.cugcs.famdoc.model.PatInf;
import com.cugcs.famdoc.model.Patient;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.DoctorService;
import com.cugcs.famdoc.service.PatInfService;
import com.cugcs.famdoc.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PatientViewController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatInfService patInfService;


    @RequestMapping("/patientview")
    public String patientview(HttpSession httpSession,Model model) throws ParseException {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        Doctor doc = doctorService.loadDocByUser(username);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        Date date1 = formatter.parse(time);

        Long LprsNum = patInfService.selectLprsNum(doc.getDoc_id(),date1);
        model.addAttribute("lprsnum",LprsNum);

        Long HprsNum = patInfService.selectHprsNum(doc.getDoc_id(),date1);
        model.addAttribute("hprsnum",HprsNum);

        Long OwNum = patInfService.selectOwNum(doc.getDoc_id(),date1);
        model.addAttribute("ownum",OwNum);
        String time2 = time.replace("-","");
        model.addAttribute("currentDay",time2);
        System.out.println(LprsNum);
        System.out.println(time);
        return "patientview";
    }

}
