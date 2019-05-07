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

    @Override
    public List<category> findvalueByid(int category_id) {
        List<category> value = categoryDao.findvalueByid(category_id);
        return value;
    }

    @Override
    public category findidByname(String name) {
        category list=categoryDao.findidByname(name);
        return list;
    }

    @Override
    public void deletecategoryBycategoryid(int categoryid) {
        categoryDao.deletecategoryBycategoryid(categoryid);
    }

    @Override
    public category findcategoryByid(int categoryid) {
        return categoryDao.findcategoryByid(categoryid);
    }

    @Override
    public void updatecategoryBycategoryid(category categorys) {
categoryDao.updatecategoryBycategoryid(categorys);
    }

    @Override
    public void save(category categorys) {
categoryDao.save(categorys);
    }


}
