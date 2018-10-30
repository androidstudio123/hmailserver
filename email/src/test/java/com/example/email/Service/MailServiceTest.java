package com.example.email.Service;

import com.example.email.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
   private  MailService MailService;
    @Test
    public void testSimpleMail() throws Exception {
        MailService.sendSimpleMail("1045728428@qq.com","个人发送的简单邮件"," hello world!");
    }
}