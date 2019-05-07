package com.example.email.service;

import com.example.email.bean.category;

import java.util.List;
import java.util.Map;

public interface Categoryservice {
    List<category> findAll();
    Map<Integer,String> listByMap();
    List<category> findvalueByid(int category_id);
    category findidByname(String name);

    void deletecategoryBycategoryid(int categoryid);
    category findcategoryByid(int categoryid);
    void updatecategoryBycategoryid(category categorys);
    void save(category categorys);
}
