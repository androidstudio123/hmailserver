package com.example.email.dao;

import com.example.email.bean.commimage;

import java.util.List;

public interface CommoimageDao {
    List<commimage> findBycommodityid(int commodity_id);
}
