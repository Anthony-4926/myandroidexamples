package com.example.orderself.util;

import com.example.orderself.entity.Food;

import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-14 9:22
 */
public class Utils {
    private static int nowOrderId;
    private static List<Food> foodList;
    public static int getNowOrderId() {
        return nowOrderId;
    }

    public static void setNowOrderId(int id) {
        nowOrderId = id;
    }

    public static List<Food> getFoodList() {
        return foodList;
    }

    public static void setFoodList(List<Food> foodList) {
        Utils.foodList = foodList;
    }
}
