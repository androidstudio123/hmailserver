package com.example.email.service;

import com.example.email.bean.category;

import java.util.List;
import java.util.Map;

public interface Categoryservice {
    List<category> findAll();
    Map<Integer,String> listByMap();
}
