package com.example.email.dao;

import com.example.email.bean.category;
import com.example.email.bean.commodity;

import java.util.List;

public interface CategoryDao {
    List<category> findAll();
    List<category> findvalueByid(int category_id);
    category findidByname(String name);
}
