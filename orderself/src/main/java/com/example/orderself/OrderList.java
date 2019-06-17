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
import android.widget.TextView;

import com.example.orderself.adapter.FoodListAdapter;
import com.example.orderself.adapter.OrderFoodListAdapter;
import com.example.orderself.database.FoodDatabase;
import com.example.orderself.database.OrderDatabase;
import com.example.orderself.entity.Food;
import com.example.orderself.entity.Order;
import com.example.orderself.util.Utils;

import java.net.SocketTimeoutException;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderList extends Fragment {
    private Order order;
    private RecyclerView recyclerView;
    private OrderFoodListAdapter adapter;
    double totalPrice;
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
        ((TextView)getActivity().findViewById(R.id.order_list_postion)).setText(""+(OrderDatabase.getOrderById(Utils.getNowOrderId()).getPosition().getId()+1));
        recyclerView = getActivity().findViewById(R.id.recyclerview_order_foods);
//        创建布局管理器
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        adapter = new OrderFoodListAdapter(order.getFoods(), getContext());
        recyclerView.setAdapter(adapter);

        totalPrice=0;
        for (Food f : OrderDatabase.getOrderById(Utils.getNowOrderId()).getFoods()) {
            totalPrice+=(f.getPrice()*f.getAmount()*f.getDiscount()/10);
        }
        ((TextView) getActivity().findViewById(R.id.total_price)).setText(""+totalPrice);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        order=OrderDatabase.getOrderById(Utils.getNowOrderId());
        adapter.setFoodList(order.getFoods());
        adapter.notifyDataSetChanged();
    }

}
