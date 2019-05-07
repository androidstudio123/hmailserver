package com.example.email.dao;

import com.example.email.bean.category;
import com.example.email.bean.commodity;

import java.util.List;

public interface CategoryDao {
    List<category> findAll();
    List<category> findvalueByid(int category_id);
    category findidByname(String name);

    void deletecategoryBycategoryid(int categoryid);
    category findcategoryByid(int categoryid);
    void updatecategoryBycategoryid(category categorys);
    void save(category categorys);
}
