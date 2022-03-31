package com.cugcs.famdoc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通知页面
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }


    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

}
