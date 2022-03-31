package com.cugcs.famdoc.controller;
import com.cugcs.famdoc.model.User;
import com.cugcs.famdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ChangePasswordController {

    @Autowired
    private UserService userService;

    @RequestMapping("/changepassword")
    public String changepassword() {
        return "changepassword";
    }


    @PostMapping("/dochange")
    public String dochang(String password, String newpassword, Model model, HttpSession httpSession) {
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String username = currentUser.getUsername();
        User user = userService.doLogin2(username, password);
        if (user == null) {
            model.addAttribute("error", "用户名或原密码输入错误，修改失败");
            return "forward:changepassword";
        } else {
            userService.doChang(username, newpassword);
        }
        return "redirect:/logout";
    }
}
