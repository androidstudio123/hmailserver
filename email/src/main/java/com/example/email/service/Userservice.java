package com.example.email.service;

import com.example.email.bean.login;
import com.example.email.bean.user;

import java.util.List;

public interface Userservice {
    void saveuser(user list) ;
    List<user> findAlluser();
    List<user> finduseridByusername(String username);
    user findAlluserByid(int id);
}
