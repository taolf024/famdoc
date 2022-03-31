package com.cugcs.famdoc.controller;

import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String users(Model model,HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        model.addAttribute("users",userService.getAllUser(username));

        return "users";
    }
}
