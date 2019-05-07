package com.example.email.controller.AdminController;

import com.example.email.bean.login;
import com.example.email.bean.user;
import com.example.email.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminLoginController {
    @Autowired
    private Userservice userservice;
    @RequestMapping("admin")
    public String adminlogin(){
        return "admin/login";
    }
    @RequestMapping("adminlogin")
    public String login(Model m, user user, HttpServletRequest request){
        List<user> list=new ArrayList<>();
        list=userservice.findAlluser();
        for (user use : list) {
            if (user.getUsername().equals(use.getUsername()) && user.getPassword().equals(use.getPassword())) {
                m.addAttribute("username", user.getUsername());
                m.addAttribute("user", use);
                request.getSession().setAttribute("username", use.getUsername());
                request.getSession().setAttribute("id", use.getId());
                String session = (String) request.getSession().getAttribute(String.valueOf(use));
                return "redirect:adminusergrid";
            }

        }
        m.addAttribute("adminerr", "用户名或密码错误！");
        return "admin/login";
    }
}
