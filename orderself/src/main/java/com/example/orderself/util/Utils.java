package com.example.orderself.util;

/**
 * @author xinzhao
 * @create 2019-06-14 9:22
 */
public class Utils {
    private static int nowOrderId;

    public static int getNowOrderId() {
        return nowOrderId;
    }

    public static void setNowOrderId(int id) {
        nowOrderId = id;
    }
}
