package com.example.email.controller.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {
    @RequestMapping("admin")
    public String adminlogin(){
        return "admin/login";
    }
}
