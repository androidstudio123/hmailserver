package com.example.email.controller.AdminController;

import com.example.email.bean.order;
import com.example.email.service.Orderservice;
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
public class AdminOrderController {
    @Autowired
    private Orderservice orderservice;
    @RequestMapping("adminordergrid")
    public String findAllcategory(Model m, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id asc");
        List<order> qq = new ArrayList<>();
        qq=orderservice.findAllorder();
        PageInfo<order> orderpage=new PageInfo<>(qq);
        m.addAttribute("page", orderpage);
        return "admin/ordergrid";
    }

    @RequestMapping("delivergoods")
    public String completepay(Model m,@RequestParam int orderid){
        orderservice.delivergoods(orderid);
        return "redirect:adminordergrid";
    }
    @RequestMapping("deleteorders")
    public String deleteorders(Model m,@RequestParam int orderid){
        orderservice.deleteorderByorderid(orderid);
        return "redirect:adminordergrid";
    }
}
