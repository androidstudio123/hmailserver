package com.example.email.service.impl;

import com.example.email.bean.login;
import com.example.email.dao.AdminUserDao;
import com.example.email.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;
    @Override
    public List<login> findloginByLoginid(int login_id) {
        return null;
    }

    @Override
    public void savelogin(login login) {

    }

    @Override
    public void deleteloginBylogin_id(int login_id) {

    }

    @Override
    public List<login> findAll() {
        return adminUserDao.findAll();
    }

    @Override
    public void updatelogin(int login_id) {

    }
}
