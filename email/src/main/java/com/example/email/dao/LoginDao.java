package com.example.email.dao;


import com.example.email.bean.login;
import java.util.List;
public interface Logindao {
    //gggg
    List<login> findAll();
    void save(login list);
}
