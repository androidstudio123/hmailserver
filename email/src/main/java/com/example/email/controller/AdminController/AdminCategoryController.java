package com.example.email.controller.AdminController;

import com.example.email.bean.category;
import com.example.email.bean.commodity;
import com.example.email.service.Categoryservice;
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
public class AdminCategoryController {
    @Autowired
    private Categoryservice categoryservice;
    @RequestMapping("admincategorygrid")
    public String findAllcategory(Model m, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id asc");
        List<category> qq = new ArrayList<>();
        qq=categoryservice.findAll();
        PageInfo<category> categorypage=new PageInfo<>(qq);
        m.addAttribute("page", categorypage);
        return "admin/categorygrid";
    }


    /**
     * 编辑页面跳转
     * @param m
     * @param categoryid
     * @return
     */
    @RequestMapping("updatecategory")
    public String updatecategory1(Model m,int categoryid){
        category category= categoryservice.findcategoryByid(categoryid);
        m.addAttribute("category",category);
        return "admin/updatecategory";
    }
    /**
     * 编辑商城用户信息
     * @param m
     * @param categorys
     * @return
     */
    @RequestMapping("updatecategorygrid")
    public String updatecategory(Model m,category categorys){
        categoryservice.updatecategoryBycategoryid(categorys);
        return "redirect:admincategorygrid";
    }

    @RequestMapping("deletecategorygrid")
    public String deletecategory(Model m, int categoryid){
        categoryservice.deletecategoryBycategoryid(categoryid);
        return "redirect:admincategorygrid";
    }
    @RequestMapping("savecategory")
    public String savelogin1(Model m){
        return "admin/savecategory";
    }
    @RequestMapping("savecategorygrid")
    public String savelogin(Model m, category categorys){
        categoryservice.save(categorys);
        return "redirect:admincategorygrid";
    }

}
