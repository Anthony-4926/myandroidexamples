package com.example.orderself;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.orderself.adapter.FoodListAdapter;
import com.example.orderself.adapter.OrderFoodListAdapter;
import com.example.orderself.database.FoodDatabase;
import com.example.orderself.database.OrderDatabase;
import com.example.orderself.entity.Order;
import com.example.orderself.util.Utils;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderList extends Fragment {
    private Order order;
    private RecyclerView recyclerView;
    private OrderFoodListAdapter adapter;
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
        order = OrderDatabase.getOrderById(Utils.getNowOrderId());
        recyclerView = getActivity().findViewById(R.id.recyclerview_foods);
//        创建布局管理器
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
//        添加动画

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(itemAnimator);
//        添加recyclerViewItem分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        adapter = new OrderFoodListAdapter(order.getFoods(), getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        order=OrderDatabase.getOrderById(Utils.getNowOrderId());
        adapter.notifyDataSetChanged();
    }

}
