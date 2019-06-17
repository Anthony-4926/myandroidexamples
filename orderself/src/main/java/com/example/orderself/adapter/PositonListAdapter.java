package com.example.orderself.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.orderself.R;
import com.example.orderself.database.PositionDatabase;
import com.example.orderself.entity.Position;

import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-17 8:22
 */
public class PositonListAdapter extends BaseAdapter {
    private Context context;
    private int width;

    public PositonListAdapter(Context context, int width) {
        this.context = context;
        this.width = width;
    }

    @Override
    public int getCount() {
        return PositionDatabase.getPositions().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout = null;
        linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.positon_item, parent, false);
        ((TextView) linearLayout.getChildAt(0)).setText("" + (PositionDatabase.getPositions().get(position).getId() + 1));
        ((TextView) linearLayout.getChildAt(1)).setText("" + (PositionDatabase.getPositions().get(position).getState()));
        if ("不可用".equals(PositionDatabase.getPositions().get(position).getState())) {
            linearLayout.setBackgroundColor(Color.RED);
        } else {
            linearLayout.setBackgroundColor(Color.GREEN);
        }
        ViewGroup.LayoutParams params = linearLayout.getLayoutParams();
        params.height = width / 3;
        linearLayout.setLayoutParams(params);
        return linearLayout;
    }
}
