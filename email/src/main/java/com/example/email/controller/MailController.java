package com.example.email.controller;

import com.example.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping("mail")
    public String mail() {
        return "mail";
    }

   @RequestMapping("sendMail")
//    @ResponseBody
    public String sendMail(Model m,@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("content") String content) {
       mailService.sendSimpleMail(to, subject, content);
       //String too= (String) map.get(to);
       m.addAttribute("to",to);
        return "success";
    }
}
