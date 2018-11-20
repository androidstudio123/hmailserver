package com.example.email.controller;

import com.example.email.bean.login;
import com.example.email.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginDao loginDao;
    @RequestMapping("main")
    public String login(){
        return "login";
    }
@RequestMapping("login")
//@ResponseBody
    public String Login(Model m, @RequestParam("username") String username, @RequestParam("password") String password){
    List<login> list=new ArrayList<>();
    list=loginDao.findAll();
    for (login log:list) {
          if(username.equals(log.getUsername())) {
            if(password.equals(log.getPassword())){
                return "mail";
            }else{
                m.addAttribute("username",username);
              m.addAttribute("err","密码错误！");
              return "login";
            }
          }else {
              m.addAttribute("err1","用户名不存在！");
             return "login";
          }
    }
    return null;
}



    @RequestMapping("register")
    //注册aaaaaaaaaaa
    public String register(){
        return "register";
    }
}
