package com.example.email.service;

import com.example.email.bean.login;

import java.util.List;

public interface Loginservice {
    void save(login list) ;
    List<login> findAll();
    List<login> findidByusername(String username);
    login findAllByid(int id);
}
