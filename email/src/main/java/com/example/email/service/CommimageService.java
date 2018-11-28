package com.example.email.service;

import com.example.email.bean.commimage;

import java.util.List;

public interface CommimageService {
    List<commimage> findBycommodityid(int commodity_id);
}
