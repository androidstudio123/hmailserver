package com.example.email.dao;


import com.example.email.bean.login;
import com.example.email.bean.user;

import java.util.List;

public interface UserDao {
    List<user> findAlluser();
     void saveuser(user list);
    List<user>  finduseridByusername(String username);
   user findAlluserByid(int id);
}
