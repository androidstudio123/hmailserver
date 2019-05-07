package com.example.email.controller.AdminController;

import com.example.email.bean.login;
import com.example.email.bean.order;
import com.example.email.service.AdminUserService;
import com.example.email.service.Loginservice;
import com.example.email.service.Userservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
@Controller
public class AdminuserController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private Loginservice loginservice;
    @RequestMapping("adminusergrid")
    public String findlogin(Model m, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id asc");
        List<login> qq = new ArrayList<>();
        qq=adminUserService.findAll();
        PageInfo<login> page=new PageInfo<>(qq);
        m.addAttribute("page", page);
        return "admin/logingrid";
    }

    /**
     * 编辑页面跳转
     * @param m
     * @param loginid
     * @return
     */
    @RequestMapping("updatelogin")
    public String updatelogin1(Model m,int loginid){
        login login=  loginservice.findloginByid(loginid);
        m.addAttribute("login",login);
        return "admin/updatelogin";
    }
    /**
     * 编辑商城用户信息
     * @param m
     * @param logins
     * @return
     */
    @RequestMapping("updatelogingrid")
    public String updatelogin(Model m,login logins){
        loginservice.updateloginByloginid(logins);
        return "redirect:adminusergrid";
    }

    @RequestMapping("deletelogingrid")
    public String deletelogin(Model m, int loginid){
        loginservice.deleteloginByloginid(loginid);
        return "redirect:adminusergrid";
    }
    @RequestMapping("savelogin")
    public String savelogin1(Model m){
        return "admin/savelogin";
    }
    @RequestMapping("savelogingrid")
    public String savelogin(Model m, login logins){
        loginservice.save(logins);
        return "redirect:adminusergrid";
    }
}
