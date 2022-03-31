package com.cugcs.famdoc.controller;
import com.cugcs.famdoc.model.Patient;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.DoctorService;
import com.cugcs.famdoc.service.HealthDataService;
import com.cugcs.famdoc.service.PatientService;
import com.cugcs.famdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    public static String currentuser;

    @Autowired
    UserService userService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;
    @Autowired
    HealthDataService healthDataService;

    //登录页面
    @RequestMapping("/")
    public String login() {
        return "login1";
    }

    /**
     * 判断登录信息
     *
     * @param username    账号
     * @param password    密码
     * @param model
     * @param status     身份
     * @param httpSession 会话，用来保存用户登录信息
     * @return 登录成功到首页  登录失败不跳转呆在登陆页面
     */

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, String status , Model model, HttpSession httpSession) {
        User user = userService.doLogin(username, password , status);
        if (user == null) {
            model.addAttribute("error", "用户名或密码输入错误，请重试");
            return "forward:/";
        } else {
            if(user.getStatus()=="0"){
                httpSession.setAttribute("currentUser", user);
                return "/home";
            }else{
                httpSession.setAttribute("currentUser", user);
                return "/home";
            }
        }
    }


    /**
     * 注册
     *
//     * @param model
     * @return 返回register页面
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 判断注册信息
     * @param user 用户注册的信息
     * @param model
     * @return 成功返回到登录页面   失败数据回填，继续呆在注册页面
     */
    @RequestMapping("/doReg")
    public String doReg(User user, String status, String username, String name, String sex, String tel, String idnum, Model model) {
        //判断成功
        int status2 = Integer.parseInt(status);
        Integer result = userService.doReg(user);
        //user放进数据库成功否
        if (result == 1) {
            //判断身份是医生
            if (status2 == 0) {
                Integer result2 = doctorService.doReg(username,name,sex,tel,idnum);
                if (result2 == 1) {
                    return "redirect:/";
                }else{
                    model.addAttribute("error", "注册失败");
                    model.addAttribute("user", user);
                    return "forward:/register";}
            } else if(status2 == 1){            //判断身份是患者
                Integer result3 = patientService.doReg(username,name,sex,tel,idnum);
                //添加健康数据表
                Patient patient = patientService.loadPatByUser(username);
                Integer patientid = patient.getPatient_id();
                healthDataService.AddPatIdIntoHealth(patientid);
                if (result3 == 1) {
                    return "redirect:/";
                }else{
                    model.addAttribute("error", "注册失败");
                    model.addAttribute("user", user);
                    return "forward:/register";}
            }return "forward:/";
        } else {//注册失败返回
            model.addAttribute("error", "注册失败");
            model.addAttribute("user", user);
            return "forward:/register";
        }
    }

}



