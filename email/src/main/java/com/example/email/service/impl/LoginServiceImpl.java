package com.example.email.service.impl;
import com.example.email.bean.login;
import com.example.email.dao.LoginDao;
import com.example.email.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LoginServiceImpl implements Loginservice {
    @Autowired
    LoginDao loginDao;
    @Override
    public void save(login list) {
        loginDao.save(list);
    }

    @Override
    public List<login> findAll() {
        return loginDao.findAll();
    }

    @Override
    public List<login> findidByusername(String username) {
        return loginDao.findidByusername(username);
    }

    @Override
    public login findloginByid(int loginid) {
        return loginDao.findloginByid(loginid);
    }

    @Override
    public login findAllByid(int id) {
        return loginDao.findAllByid(id);
    }

    @Override
    public void updateloginByloginid(login logins) {
        loginDao.updateloginByloginid(logins);
    }


    @Override
    public void deleteloginByloginid(int loginid) {
             loginDao.deleteloginByloginid(loginid);
    }

    @Override
    public List<login> Searchlogin(String Search) {
        return loginDao.Searchlogin(Search);
    }

}
