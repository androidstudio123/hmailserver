package com.example.email.service.impl;

import com.example.email.bean.commimage;
import com.example.email.dao.CommoimageDao;
import com.example.email.service.CommimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CommimageServiceImpl implements CommimageService {
    @Autowired
    CommoimageDao commoimageDao;
    @Override
    public List<commimage> findBycommodityid(int commodity_id) {
        List<commimage> image=commoimageDao.findBycommodityid(commodity_id);
        return image;
    }
}
