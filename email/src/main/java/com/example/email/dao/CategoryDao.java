package com.example.email.dao;

import com.example.email.bean.category;
import com.example.email.bean.commodity;

import java.util.List;

public interface CategoryDao {
//    String a = "adfs";
    //接口中的方法默認識是public，所有接口中不能有實現
    List<category> findAll();
    List<category> findvalueByid(int category_id);
    category findidByname(String name);
}
