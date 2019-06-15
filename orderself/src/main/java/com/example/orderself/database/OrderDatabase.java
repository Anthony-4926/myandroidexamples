package com.example.orderself.database;

import com.example.orderself.OrderList;
import com.example.orderself.entity.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-14 9:59
 */
public class OrderDatabase {
    protected static List<Order> orderList = new ArrayList<>();
    public void insterOder(Order order){
        orderList.add(order);
    }
    public static Order getOrderById(int id){
        if (orderList.size()!=0){
            return orderList.get(id);
        }
        return null;
    }
}
