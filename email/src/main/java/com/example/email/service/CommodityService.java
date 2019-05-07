package com.example.email.service;

import com.example.email.bean.commodity;

import java.util.List;

public interface CommodityService {
    List<commodity> findAll();
    List<commodity> findBycategory_id(int category_id);
    List<commodity> findBycategory_Id(int category_id);
    List<commodity> findByquailty(String quailty);
    List<commodity> Searchcommodity(String Search);
    List<commodity> findcommodityBylogin_id(int login_id);
    List<commodity> findlogin_idBycommodity_id(int id);
    commodity save(commodity commodity);
    void deletecommByid(int comm_id);

    //void save(commodity list);
    commodity findcommByid(int commid);
    void updatecommBycommid(commodity comms);
    void deletecommBycommid(int commid);
    List<commodity> Searchcommgrid(String Search);
}
