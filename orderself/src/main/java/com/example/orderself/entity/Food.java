package com.example.orderself.entity;

import java.io.Serializable;

/**
 * @author xinzhao
 * @create 2019-06-14 9:09
 */
public class Food implements Serializable {
    private int id;
    private double price;
    private String name;
    private String intro;
    private double discount ;
    private boolean isSpecial;
    private int amount;
    private String state;
    private int img;

    public Food(int id, double price, String name, String intro, double discount, boolean isSpecial, int amount, String state, int img) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.intro = intro;
        this.discount = discount;
        this.isSpecial = isSpecial;
        this.amount = amount;
        this.state = state;
        this.img = img;
    }

    public Food() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
