package com.example.email.service.impl;

import com.example.email.bean.order;
import com.example.email.dao.OrderDao;
import com.example.email.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements Orderservice{
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<order> findorderByLoginid(int login_id) {
        return orderDao.findorderByLoginid(login_id);
    }

    @Override
    public void saveorder(order order) {
       orderDao.saveorder(order);
    }

    @Override
    public void deleteorderByorderid(int orderid) {
    orderDao.deleteorderByorderid(orderid);
    }

    @Override
    public List<order> findAllorder() {
        return orderDao.findAllorder();
    }

    @Override
    public order findorderByorderid(int orderid) {
        return orderDao.findorderByorderid(orderid);
    }

    @Override
    public void commpletepay(int orderid) {
        orderDao.commpletepay(orderid);
    }

    @Override
    public void delivergoods(int orderid) {
     orderDao.delivergoods(orderid);
    }

    @Override
    public void receivinggoods(int orderid) {
        orderDao.receivinggoods(orderid);
    }

    @Override
    public List<order> Searchorder(String Search) {
        return orderDao.Searchorder(Search);
    }


}
