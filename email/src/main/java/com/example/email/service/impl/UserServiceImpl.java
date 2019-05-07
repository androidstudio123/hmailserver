package com.example.email.service.impl;

import com.example.email.bean.user;
import com.example.email.dao.UserDao;
import com.example.email.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements Userservice {
    @Autowired
    private UserDao userDao;

    @Override
    public void saveuser(user list) {

    }

    @Override
    public List<user> findAlluser() {
        return userDao.findAlluser();
    }

    @Override
    public List<user> finduseridByusername(String username) {
        return null;
    }

    @Override
    public user findAlluserByid(int id) {
        return null;
    }
}
