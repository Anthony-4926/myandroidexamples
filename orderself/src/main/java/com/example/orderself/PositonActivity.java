package com.example.orderself;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderself.adapter.PositonListAdapter;
import com.example.orderself.database.OrderDatabase;
import com.example.orderself.database.PositionDatabase;
import com.example.orderself.entity.Order;
import com.example.orderself.entity.Position;
import com.example.orderself.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class PositonActivity extends AppCompatActivity {
    PositonListAdapter positonListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positon);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;// 屏幕宽度（像素）
        GridView position_list = findViewById(R.id.position_list_grid_view);
        positonListAdapter = new PositonListAdapter(this, width);
        position_list.setAdapter(positonListAdapter);

        position_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView state = (TextView) ((LinearLayout) view).getChildAt(1);
                TextView number = (TextView) ((LinearLayout) view).getChildAt(0);
                if ("不可用".equals(state.getText())) {
                    Toast.makeText(PositonActivity.this, "桌台不可用", Toast.LENGTH_SHORT).show();
                } else {
                    new AlertDialog.Builder(PositonActivity.this).setTitle(number.getText() + "号桌")
                            .setMessage("确认开台？")
                            .setPositiveButton("确定", (d, w) -> {
//                                Toast.makeText(PositonActivity.this, number.getText() + "号桌" + "开台", Toast.LENGTH_SHORT).show();
                                openPosition(PositionDatabase.getPositions().get(position));
                            }).setNegativeButton("取消", (d, w) -> {
                    }).show();
                }
            }
        });
    }

    protected void openPosition(Position p){
//        System.out.println(OrderDatabase.getOrderListSize());
        Order order = new Order(OrderDatabase.getOrderListSize());
        order.setPosition(p);
        Utils.setNowOrderId(order.getId());
        PositionDatabase.getPositions().get(p.getId()).setState("不可用");
        System.out.println(PositionDatabase.getPositions().get(p.getId()).getState());
        OrderDatabase.insertOrder(order);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }



}

