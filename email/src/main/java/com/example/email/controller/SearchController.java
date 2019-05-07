package com.example.email.controller;

import com.example.email.bean.commodity;
import com.example.email.bean.login;
import com.example.email.bean.order;
import com.example.email.service.AdminUserService;
import com.example.email.service.CommodityService;
import com.example.email.service.Loginservice;
import com.example.email.service.Orderservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    CommodityService commodityService;
@Autowired
private Loginservice loginservice;
@Autowired
private AdminUserService adminUserService;
@Autowired
private Orderservice orderservice;
    /**
     * 用户进行商品查询功能
     * @param m
     * @param Search
     * @param start
     * @param size
     * @return
     */
    @GetMapping("Searchcommodity")
    public String Searchcommodity(Model m, @RequestParam String Search,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="8") int size){
        PageHelper.startPage(start,size,"id desc");
        List<commodity> list=commodityService.Searchcommodity('%'+Search+'%');
        PageInfo<commodity> page=new PageInfo<>(list);
        m.addAttribute("page", page);
        m.addAttribute("jieguo","搜索结果");
        m.addAttribute("search",Search);
        return "search";
    }
    @GetMapping("Searchlogingrid")
    public String Searchlogingrid(Model m, @RequestParam String Search,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id asc");
        List<login> qq = new ArrayList<>();
        if(Search==""){
            qq=adminUserService.findAll();
        }else{
            qq=loginservice.Searchlogin('%'+Search+'%');
        }
        PageInfo<login> page=new PageInfo<>(qq);
        m.addAttribute("page", page);
        return "admin/logingrid";
    }

    @GetMapping("Searchcommgrid")
    public String Searchcommgrid(Model m, @RequestParam String Search,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id desc");
        List<commodity> qq = new ArrayList<>();
        if(Search==""){
            qq=commodityService.findAll();
        }else{
            qq=commodityService.Searchcommgrid('%'+Search+'%');
        }
        PageInfo<commodity> page=new PageInfo<>(qq);
        m.addAttribute("page", page);
        return "admin/commgrid";
    }

    @GetMapping("Searchcategorygrid")
    public String Searchcategorygrid(Model m, @RequestParam String Search,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id desc");
        List<commodity> qq = new ArrayList<>();
        if(Search==""){
            qq=commodityService.findAll();
        }else{
            qq=commodityService.Searchcommgrid('%'+Search+'%');
        }
        PageInfo<commodity> page=new PageInfo<>(qq);
        m.addAttribute("page", page);
        return "admin/categorygrid";
    }
    @GetMapping("Searchordergrid")
    public String Searchordergrid(Model m, @RequestParam String Search,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id asc");
        List<order> qq = new ArrayList<>();
        if(Search==""){
            qq=orderservice.findAllorder();
        }else{
            qq=orderservice.Searchorder('%'+Search+'%');
        }
        PageInfo<order> page=new PageInfo<>(qq);
        m.addAttribute("page", page);
        return "admin/ordergrid";
    }
}
