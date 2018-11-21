package com.example.email.service.impl;

import com.example.email.bean.category;
import com.example.email.dao.CategoryDao;
import com.example.email.service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryServiceImpl implements Categoryservice {
    @Autowired
    CategoryDao categoryDao;
    @Override
    public List<category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Map<Integer, String> listByMap() {
        List<category> categories = categoryDao.findAll();
        Map<Integer, String> categoriesMap = new HashMap<>();
        for (category category : categories) {
            categoriesMap.put(category.getId(),category.getName());
        }
        return categoriesMap;
    }
}
