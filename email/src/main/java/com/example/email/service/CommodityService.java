package com.example.email.service;

import com.example.email.bean.commodity;

import java.util.List;
import java.util.Map;

public interface CommodityService {
    List<commodity> findAll();
    List<commodity> findBycategory_id(int category_id);
    List<commodity> findBycategory_Id(int category_id);
    List<commodity> findByquailty(String quailty);
    List<commodity> Searchcommodity(String Search);
}
