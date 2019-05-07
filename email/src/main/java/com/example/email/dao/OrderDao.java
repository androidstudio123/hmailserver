package com.example.email.dao;
import com.example.email.bean.order;


import java.util.List;
public interface OrderDao {
    //通过用户id查询用户订单
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
