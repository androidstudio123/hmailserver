package com.example.email.service;

import com.example.email.bean.login;

import java.util.List;

public interface Loginservice {
    List<login> findAll();
    List<login> findidByusername(String username);
    login findAllByid(int id);

    void save(login list);
    login findloginByid(int loginid);
    void updateloginByloginid(login logins);
    void deleteloginByloginid(int loginid);

    List<login> Searchlogin(String Search);
}
