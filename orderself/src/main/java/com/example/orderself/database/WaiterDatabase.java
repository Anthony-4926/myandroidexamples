package com.example.orderself.database;

import com.example.orderself.entity.Waiter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-14 9:41
 */
public class WaiterDatabase {
    protected List<Waiter> Waiters = initWaiters();

    public List<Waiter> getWaiters() {
        return Waiters;
    }

    protected static List<Waiter> initWaiters(){
        List<Waiter> waiterList = new ArrayList<>();
        waiterList.add(new Waiter(waiterList.size(),
                "赵鑫",
                2016211252,
                "201621"));
        return waiterList;
    }

}
