package com.example.orderself.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderself.R;
import com.example.orderself.entity.Food;

import java.util.List;

public class OrderFoodListAdapter extends RecyclerView.Adapter<OrderFoodListAdapter.MyHolder2> {
    private static List<Food> foodList;
    private Context context;

    public OrderFoodListAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    public static void setFoodList(List<Food> newFoodList) {
        foodList = newFoodList;
    }

    @NonNull
    @Override
    public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_order_food_list, parent, false);
        return new OrderFoodListAdapter.MyHolder2(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
        holder.name.setText(foodList.get(position).getName());
        holder.amount.setText(foodList.get(position).getAmount());
        holder.price.setText("" + foodList.get(position).getPrice());
        holder.state.setText(foodList.get(position).getState());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class MyHolder2 extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView amount;
        public TextView price;
        public TextView state;
        public MyHolder2(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ordere_food_list_name);
            amount = itemView.findViewById(R.id.ordere_food_list_amount);
            price = itemView.findViewById(R.id.ordere_food_list_price);
            state = itemView.findViewById(R.id.ordere_food_list_state);
        }
    }
}
