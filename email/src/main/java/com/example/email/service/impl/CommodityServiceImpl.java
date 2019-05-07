package com.example.email.service.impl;

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
public class CommodityServiceImpl  implements CommodityService {
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
            numbersMap.put(number.getName(), number.getDescrip());
        }
        return numbers;
    }

    @Override
    public List<commodity> findBycategory_Id(int category_id) {
        List<commodity> list = commodityDao.findBycategory_Id(category_id);
        return list;
    }

    @Override
    public List<commodity> findByquailty(String quailty) {
        List<commodity> list = commodityDao.findByquailty(quailty);
        return list;
    }

    @Override
    public List<commodity> Searchcommodity(String Search) {
        List<commodity> list=commodityDao.Searchcommodity(Search);
        return list;
    }

    @Override
    public List<commodity> findcommodityBylogin_id(int login_id) {
        List<commodity> list=commodityDao.findcommodityBylogin_id(login_id);
        return list;
    }

    @Override
    public List<commodity> findlogin_idBycommodity_id(int id) {
        List<commodity> list=commodityDao.findlogin_idBycommodity_id(id);
        return list;
    }

    @Override
    public commodity save(commodity commodity) {
        commodityDao.save(commodity);
        return commodity;
    }

    @Override
    public void deletecommByid(int comm_id) {
        commodityDao.deletecommByid(comm_id);
    }

    @Override
    public commodity findcommByid(int commid) {
        return commodityDao.findcommByid(commid);
    }

    @Override
    public void updatecommBycommid(commodity comms) {
    commodityDao.updatecommBycommid(comms);
    }

    @Override
    public void deletecommBycommid(int commid) {
     commodityDao.deletecommByid(commid);
    }

    @Override
    public List<commodity> Searchcommgrid(String Search) {
        return commodityDao.Searchcommgrid(Search);
    }

}
