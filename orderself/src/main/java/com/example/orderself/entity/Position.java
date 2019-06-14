package com.example.orderself.entity;

/**
 * @author xinzhao
 * @create 2019-06-14 9:15
 */
public class Position {
    private int id;
    private String state;

    public Position(int id, String state) {
        this.id = id;
        this.state = state;
    }

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
