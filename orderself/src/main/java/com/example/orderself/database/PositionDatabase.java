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
    protected List<Position> positions = initPositions();


    public List<Position> getPositions() {
        return positions;
    }

    protected static List<Position> initPositions(){
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(positions.size(),"可用"));
        return positions;
    }

}
