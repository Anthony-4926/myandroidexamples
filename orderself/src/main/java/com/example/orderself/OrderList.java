package com.example.orderself;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orderself.database.OrderDatabase;
import com.example.orderself.entity.Order;
import com.example.orderself.util.Utils;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderList extends Fragment {
    private Order order;

    public OrderList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rend();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        order=OrderDatabase.getOrderById(Utils.getNowOrderId());
    }

    /**
     * 负责渲染页面
     */
    protected void rend(){

    }
}
