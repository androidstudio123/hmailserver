package com.example.email.controller;

import com.example.email.bean.category;
import com.example.email.bean.commodity;
import com.example.email.bean.login;
import com.example.email.service.CommodityService;
import com.example.email.service.Loginservice;
import com.example.email.service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private Loginservice loginservice;
    @Autowired
    private Categoryservice Categoryservice;
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("main")
    public String login() {
        return "face1";
    }

    @RequestMapping("main1")
    public String login1() {
        return "home";
    }
    @RequestMapping("login")
//@ResponseBody
    public String Login(Model m, login login, HttpServletRequest request) {
//        request.getSession().setAttribute("username", login);
//        String session = (String) request.getSession().getAttribute(String.valueOf(login));
        List<login> list = new ArrayList<>();
        list = loginservice.findAll();

        Map<Integer, String> categories = Categoryservice.listByMap();
        List<commodity> list1 = new ArrayList<>();
        list1 = commodityService.findAll();
        for (login log : list) {
            if (login.getUsername().equals(log.getUsername()) && login.getPassword().equals(log.getPassword())) {
                m.addAttribute("username", login.getUsername());
                m.addAttribute("categories", categories);
                m.addAttribute("commodities", list1);
                //m.addAttribute("session", session);
                m.addAttribute("user", log);
                request.getSession().setAttribute("username", log);
                String session = (String) request.getSession().getAttribute(String.valueOf(log));
                return "home";
//            }else{
//                m.addAttribute("username",username);
//              m.addAttribute("err","密码错误！");
//              return "login";
//            }
//          }else {
//              m.addAttribute("err1","用户名不存在！");
//             return "login";
//         }
            }

        }
        m.addAttribute("err", "用户名或密码错误！");
        return "login";
    }

    @RequestMapping("loginin")
    public String loginin(Model m) {
        Map<Integer, String> categories = Categoryservice.listByMap();
        List<commodity> list1 = new ArrayList<>();
        list1 = commodityService.findAll();
        List<login> list = new ArrayList<>();
        list = loginservice.findAll();

        for (login log : list) {
            m.addAttribute("categories", categories);
            m.addAttribute("commodities", list1);
            m.addAttribute("user", log);
        }
        return "home";
    }


    @RequestMapping("register")
    //@ResponseBody
    public String register(Model m, login list) {
        //login log = JSON
        List<login> list1 = new ArrayList<>();
        list1 = loginservice.findAll();

        if (list.getUsername() == "" || list.getPassword() == "") {
            m.addAttribute("err1", "用户名或密码不能为空！");
            return "register";
        } else {
            for (login login : list1) {
                if ((list.getUsername()).equals(login.getUsername())) {
                    m.addAttribute("err2", "用户名已存在！");
                    return "register";
                }
            }
            loginservice.save(list);
            return "login";

        }

    }

    @RequestMapping("Register")
    public String Register() {
        return "register";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("username");
        return "login";
    }
}
