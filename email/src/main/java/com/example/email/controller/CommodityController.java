package com.example.email.controller;

import com.example.email.bean.category;
import com.example.email.bean.commimage;
import com.example.email.bean.commodity;
import com.example.email.bean.login;
import com.example.email.service.Categoryservice;
import com.example.email.service.CommimageService;
import com.example.email.service.CommodityService;
import com.example.email.service.Loginservice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {

    private static String UPLOADED_FOLDER = "D://hMailserver//hmailserver//hmailserver//email//src//main//resources//static//img//comm//";
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private Categoryservice categoryservice;
    @Autowired
    private CommimageService commimageService;
    @Autowired
    private Loginservice loginservice;

    @GetMapping("/gocomm")
    public String findBycategory_id(Model m, @RequestParam int category_id,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="8") int size) throws Exception {
        List<commodity> list = new ArrayList<>();
        list=commodityService.findBycategory_id(category_id);
        m.addAttribute("list",list);
        List<category> value = categoryservice.findvalueByid(category_id);
        category value1= value.get(0);
        m.addAttribute("categoryvalue",value1);

         PageHelper.startPage(start,size,"id desc");
        List all=commodityService.findBycategory_Id(category_id);
       PageInfo<commodity> page=new PageInfo<>(all);
        m.addAttribute("page", page);
        return "commodity";
    }
@RequestMapping("goodcomm")
    public String findQuality(Model m,@RequestParam(defaultValue ="good") String quailty,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="8") int size){
    PageHelper.startPage(start,size,"id desc");
    List<commodity> qq = new ArrayList<>();
    qq=commodityService.findByquailty(quailty);
    PageInfo<commodity> page=new PageInfo<>(qq);
    m.addAttribute("page", page);
    m.addAttribute("categoryvalue","商品良品");
        return "goodcommodity";
}

@RequestMapping("findcommodityiamgeBycommodity_id")
    public String findcommodityiamgeBycommodity_id(Model m,@RequestParam int commodity_id){
        List<commimage> image=commimageService.findBycommodityid(commodity_id);
        List<commodity> commodity=commodityService.findlogin_idBycommodity_id(commodity_id);
          commimage image1=image.get(0);
          commodity iimage1=commodity.get(0);
        m.addAttribute("image",image1);
       m.addAttribute("loginid",iimage1);
        return "commodityimage";
    }

    @RequestMapping("myTransanction")
    public String findcommodityBylogin_id(Model m,@RequestParam int login_id ,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue="6") int size){
        PageHelper.startPage(start,size,"id desc");
      List<commodity> shelf=commodityService.findcommodityBylogin_id(login_id);
        PageInfo<commodity> page=new PageInfo<>(shelf);
        m.addAttribute("page", page);
        m.addAttribute("shelf",shelf);
        m.addAttribute("login",login_id);
        return "mycommodityshelf";
    }
    @RequestMapping("upload")
    public String upload(Model m){
       List<category> categoryList=categoryservice.findAll();
       m.addAttribute("categoryLists",categoryList);
        return "uploadsell";
    }
    @RequestMapping("savecomm")
    public String savecomm(Model m ,commodity commodity,@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes){
        commodity.setFilename(file.getOriginalFilename());//将文件的原名字赋值给filename字段
        commodity.setCategory_id(categoryservice.findidByname(commodity.getType()).getId());
           commodityService.save(commodity);
        Map<Integer, String> categories = categoryservice.listByMap();
        List<commodity> list1 = new ArrayList<>();
        list1 = commodityService.findAll();
        List<login> list = new ArrayList<>();
        list = loginservice.findAll();

        for (login log : list) {
            m.addAttribute("categories", categories);
            m.addAttribute("commodities", list1);
            m.addAttribute("user", log);
        }

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "uploadStatus";
        }

        try {
            // Get the file and save it somewherecc
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        m.addAttribute("img",file.getOriginalFilename());
        return "home";
    }
}
