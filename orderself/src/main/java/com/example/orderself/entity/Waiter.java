package com.example.orderself.entity;

/**
 * @author xinzhao
 * @create 2019-06-14 9:14
 */
public class Waiter {
    private int id;
    private String name;
    private int number;
    private String password;

    public Waiter() {
    }

    public Waiter(int id, String name, int number, String password) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.password = password;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
