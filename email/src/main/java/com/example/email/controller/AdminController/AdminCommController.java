package com.example.email.controller.AdminController;

import com.example.email.bean.category;
import com.example.email.bean.commodity;
import com.example.email.bean.login;
import com.example.email.service.Categoryservice;
import com.example.email.service.CommodityService;
import com.example.email.service.Loginservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class AdminCommController {
@Autowired
private CommodityService commodityService;
@Autowired
private Categoryservice categoryservice;
@Autowired
private Loginservice loginservice;
    private static String UPLOADED_FOLDER = "E://hmailserver-master//email//src//main//resources//static//img//comm//";

    @RequestMapping("admincommgrid")
    public String findAllcommodity(Model m, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue="10") int size){
        PageHelper.startPage(start,size,"id desc");
        List<commodity> qq = new ArrayList<>();
        qq=commodityService.findAll();
        PageInfo<commodity> commpage=new PageInfo<>(qq);
        m.addAttribute("page", commpage);
        return "admin/commgrid";
    }

    @RequestMapping("tosavecommgrid")
    public String upload(Model m){
        List<category> categoryList=categoryservice.findAll();
        m.addAttribute("categoryLists",categoryList);
        return "admin/savecomm";
    }
    @RequestMapping("savecommgrid")
    public String Savecomm(Model m , commodity commodity, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        commodity.setFilename(file.getOriginalFilename());//将文件的原名字赋值给filename字段
        category a=categoryservice.findidByname(commodity.getType());
        commodity.setCategory_id(a.getId());
        commodityService.save(commodity);
        Map<Integer, String> categories = categoryservice.listByMap();
        List<commodity> list1 = new ArrayList<>();
        list1 = commodityService.findAll();
        List<login> list = new ArrayList<>();
        list = loginservice.findAll();
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            //先将文件转换为字节序列，保证该系统可以正确读取
            //使用平台的默认字符集将字符串编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
//            Files.write()

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        m.addAttribute("img",file.getOriginalFilename());
        return "redirect:admincommgrid";
    }


    @RequestMapping("updatecomm")
    public String updatecomm1(Model m,int commid){
        commodity comm =  commodityService.findcommByid(commid);
        List<category> categoryList=categoryservice.findAll();
        m.addAttribute("categoryLists",categoryList);
        m.addAttribute("comm",comm);
        return "admin/updatecomm";
    }
    /**
     * 编辑商城商品信息
     * @param m
     * @param comms
     * @return
     */
    @RequestMapping("updatecommgrid")
    public String updatecomm(Model m,commodity comms,@RequestParam("file") MultipartFile file){
        if(file.getOriginalFilename()==""){
            comms.setFilename(comms.getFilename());
        }else{
            comms.setFilename(file.getOriginalFilename());
        }
        commodityService.updatecommBycommid(comms);
        return "redirect:admincommgrid";
    }

    @RequestMapping("deletecommgrid")
    public String deletecomm(Model m, int commid){
        commodityService.deletecommByid(commid);
        return "redirect:admincommgrid";
    }
}
