package com.example.email.service.impl;
import com.example.email.bean.login;
import com.example.email.dao.Logindao;
import com.example.email.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LoginServiceImpl implements Loginservice {
    @Autowired
    Logindao logindao;
    @Override
    public void save(login list) {
        logindao.save(list);
    }

    @Override
    public List<login> findAll() {
        return logindao.findAll();
    }
}
