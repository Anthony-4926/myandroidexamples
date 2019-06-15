package com.example.orderself.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderself.R;

public class OrderFoodListAdapter extends RecyclerView.Adapter<OrderFoodListAdapter.MyHolder2> {


    @NonNull
    @Override
    public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MyHolder2 extends RecyclerView.ViewHolder {
        public MyHolder2(@NonNull View itemView) {
            super(itemView);
        }
    }
}
