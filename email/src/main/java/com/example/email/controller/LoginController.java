package com.example.email.controller;

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
import javax.servlet.http.HttpSession;
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
    public String login(){
        return "login";
    }
@RequestMapping("login")
//@ResponseBody
    public String Login(Model m, @RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request) {
    request.getSession().setAttribute("username", username);
    String session = request.getSession().getId();
    List<login> list = new ArrayList<>();
    list = loginservice.findAll();
    Map<Integer, String> categories = Categoryservice.listByMap();
    List<commodity> list1 = new ArrayList<>();
    list1 = commodityService.findAll();

        for (login log : list) {
            if (username.equals(log.getUsername()) && password.equals(log.getPassword())) {
                m.addAttribute("username", username);
                m.addAttribute("categories", categories);
                m.addAttribute("commodities", list1);
                m.addAttribute("session",session);

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


    @RequestMapping("register")
     //@ResponseBody
    public String register(Model m, login list) {
        //login log = JSON
        List<login> list1=new ArrayList<>();
         list1 =  loginservice.findAll();

            if (list.getUsername() == ""|| list.getPassword() == "") {
                m.addAttribute("err1", "用户名或密码不能为空！");
                return "register";
            } else  {
                for(login login : list1){
                    if((list.getUsername()).equals(login.getUsername())){
                        m.addAttribute("err2","用户名已存在！");
                        return "register";
                    }
                }
                loginservice.save(list);
                return "login";

            }

        }



    @RequestMapping("Register")
 public String Register(){
     return "register";
  }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("username");
        return "login";
    }
}
