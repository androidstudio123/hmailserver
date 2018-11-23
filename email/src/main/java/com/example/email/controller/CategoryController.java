package com.example.email.controller;

import com.example.email.service.Categoryservice;
import com.example.email.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @Autowired
    private Categoryservice categoryservice;
    @Autowired
    private CommodityService commodityService;
    @RequestMapping("gocommodity")
    public String commodity(){
        return "commodity";
    }
}
