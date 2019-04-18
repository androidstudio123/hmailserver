package com.example.email.dao;


import com.example.email.bean.commodity;

import java.util.List;

public interface CommodityDao {
    List<commodity> findAll();
    List<commodity> findBycategory_id(int category_id);
    List<commodity> findBycategory_Id(int category_id);
    List<commodity> findByquailty(String quailty);
    List<commodity> Searchcommodity(String Search);
    List<commodity> findcommodityBylogin_id(int login_id);
    List<commodity> findlogin_idBycommodity_id(int id);
    void save(commodity commodity);
    void deletecommByid(int comm_id);
}
