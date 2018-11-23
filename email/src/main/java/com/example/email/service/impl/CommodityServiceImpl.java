package com.example.email.service.impl;

import com.example.email.bean.category;
import com.example.email.bean.commodity;
import com.example.email.dao.CategoryDao;
import com.example.email.dao.CommodityDao;
import com.example.email.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class CommodityServiceImpl  implements CommodityService{
    @Autowired
    CommodityDao commodityDao;
    @Autowired
    CategoryDao categoryDao;
    @Override
    public List<commodity> findAll() {
        return commodityDao.findAll();
    }

    @Override
    public List<commodity> findBycategory_id(int category_id) {
        List<commodity> numbers = commodityDao.findBycategory_id(category_id);
        Map<String, String> numbersMap = new HashMap<>();
        for (commodity number : numbers) {
           numbersMap.put(number.getName(),number.getDescrip());
        }
        return numbers;
    }
}
