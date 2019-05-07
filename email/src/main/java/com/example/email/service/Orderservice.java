package com.example.email.service;

import com.example.email.bean.category;
import com.example.email.bean.order;

import java.util.List;
import java.util.Map;

public interface Orderservice {
    List<order> findorderByLoginid(int login_id);
    void saveorder(order order);
    void deleteorderByorderid(int orderid);
    List<order> findAllorder();
    order findorderByorderid(int orderid);
    void commpletepay(int orderid);
    void delivergoods(int orderid);
    void  receivinggoods(int orderid);
    List<order> Searchorder(String Search);
}
