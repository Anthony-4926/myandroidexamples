package com.example.orderself.database;

import android.media.RemoteControlClient;

import com.example.orderself.entity.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-14 9:45
 */
public class PositionDatabase {
    protected static List<Position> positions = initPositions();


    public static List<Position> getPositions() {
        return positions;
    }


    protected static List<Position> initPositions() {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            positions.add(new Position());
            positions.get(i).setState("可用");
            positions.get(i).setId(i);
        }
        positions.get(3).setState("不可用");
        return positions;
    }

}
