package com.example.email.service;

import com.example.email.bean.login;

import java.util.List;

public interface AdminUserService {
    List<login> findloginByLoginid(int login_id);
    void savelogin(login login);
    void deleteloginBylogin_id(int login_id);
    List<login> findAll();
    void updatelogin(int login_id);
}
