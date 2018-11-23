package com.example.email.dao;


import com.example.email.bean.commodity;

import java.util.List;

public interface CommodityDao {
    List<commodity> findAll();
    List<commodity> findBycategory_id(int category_id);
}
