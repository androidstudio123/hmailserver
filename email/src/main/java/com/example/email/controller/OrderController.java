package com.example.email.controller;

import com.example.email.bean.commodity;
import com.example.email.bean.order;
import com.example.email.service.Categoryservice;
import com.example.email.service.CommodityService;
import com.example.email.service.Orderservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private Orderservice orderservice;
   @Autowired
   private CommodityService commodityService;

    /**
     * 根据当前登录用户显示用户的订单，并实现分页
     * @param m
     * @param login_id
     * @param start
     * @param size
     * @return
     */
    @RequestMapping("goorder")
    public String findorderbyloginid(Model m, @RequestParam int login_id,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="2") int size){
        PageHelper.startPage(start,size,"id desc");
        List<order> qq = new ArrayList<>();
        qq=orderservice.findorderByLoginid(login_id);
        PageInfo<order> page=new PageInfo<>(qq);
        m.addAttribute("page", page);
        return "myorder";
    }
    @RequestMapping("deleteorder")
    public String deleteorder(Model m, @RequestParam int orderid,@RequestParam int loginid, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue="2") int size){
        orderservice.deleteorderByorderid(orderid);
       PageHelper.startPage(start,size,"id desc");
        List<order> qq = new ArrayList<>();
       qq=orderservice.findorderByLoginid(loginid);
       PageInfo<order> page=new PageInfo<>(qq);
       m.addAttribute("page", page);
        return "myorder";
    }
    @RequestMapping("tocreatecard")
    public String findcommodityiamgeBycommodity_id(Model m,@RequestParam int commodity_id){
        List<commodity> commodity=commodityService.findlogin_idBycommodity_id(commodity_id);
        //  commimage image1=image.get(0);
        commodity iimage1=commodity.get(0);
        //m.addAttribute("image",image1);
        m.addAttribute("loginid",iimage1);
        return "createorder";
    }

    @RequestMapping("saveorder")
    public String saveorder(Model m,order order){
//       Date date=new Date();
//       date.getTime();
        //List<order> saveorder = new ArrayList<>();
        orderservice.saveorder(order);
        int login_id = order.getLogin_id();
        return "redirect:goorder?login_id="+login_id;
    }

    @RequestMapping("topay")
    public String topay(Model m,int orderid){
       order list=orderservice.findorderByorderid(orderid);
        m.addAttribute("order",list);
        return "pay";
    }

    /**
     * 用户完成订单支付
     * @param m
     * @param orderid
     * @param login_id
     * @return
     */
    @RequestMapping("completepay")
    public String completepay(Model m,@RequestParam int orderid,@RequestParam int login_id){
        orderservice.commpletepay(orderid);
         return "redirect:goorder?login_id="+login_id;
    }

    /**
     * 用户确认收货
     * @param m
     * @param orderid
     * @param login_id
     * @return
     */
    @RequestMapping("receivinggoods")
    public String receivinggoods(Model m,@RequestParam int orderid,@RequestParam int login_id){
        orderservice.receivinggoods(orderid);
        return "redirect:goorder?login_id="+login_id;
    }
}
