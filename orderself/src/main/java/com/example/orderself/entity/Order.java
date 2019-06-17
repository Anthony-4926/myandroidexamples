package com.example.orderself.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-14 9:14
 */
public class Order {
    private int id;
    private Waiter waiter;
    private List<Food> foods = new ArrayList<>();
    private LocalDateTime insterTime;
    private LocalDateTime overTime;
    private Position position;

    public Order(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public LocalDateTime getInsterTime() {
        return insterTime;
    }

    public void setInsterTime(LocalDateTime insterTime) {
        this.insterTime = insterTime;
    }

    public LocalDateTime getOverTime() {
        return overTime;
    }

    public void setOverTime(LocalDateTime overTime) {
        this.overTime = overTime;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
