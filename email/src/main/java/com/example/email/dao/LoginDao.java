package com.example.email.dao;

import com.example.email.bean.login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository <login,String>{

}
