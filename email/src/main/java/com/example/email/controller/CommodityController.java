package com.example.email.controller;

import com.example.email.bean.commodity;
import com.example.email.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @GetMapping("findBycategory_id")
    public String findBycategory_id(@RequestParam int category_id, Model m){
      //  Map<String,String> numbers= (Map<String, String>) commodityService.findBycategory_id(category_id);
        List<commodity> list = new ArrayList<>();
        list=commodityService.findBycategory_id(category_id);
        m.addAttribute("list",list);
       // m.addAttribute("numbers",numbers);
        return "commodity";
    }
}
