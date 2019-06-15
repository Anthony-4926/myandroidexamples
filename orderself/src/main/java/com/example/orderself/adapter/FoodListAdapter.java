package com.example.orderself.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderself.FoodDetail;
import com.example.orderself.R;
import com.example.orderself.entity.Food;
import com.example.orderself.util.Utils;


import java.util.List;

/**
 * @author xinzhao
 * @create 2019-06-14 9:06
 */
public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyHolder>{
    private Context context;

    public FoodListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recclerview_food, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.img.setImageResource(Utils.getFoodList().get(position).getImg());
        holder.name.setText(Utils.getFoodList().get(position).getName());
        holder.amount.setText(""+Utils.getFoodList().get(position).getAmount());
        Log.d("",""+Utils.getFoodList().get(position).getDiscount());
        if(Utils.getFoodList().get(position).getDiscount()<10.0){
            holder.discount.setText(String.valueOf(Utils.getFoodList().get(position).getDiscount())+"折");
        }

        holder.price.setText("￥"+Utils.getFoodList().get(position).getPrice());
        holder.realPrice.setText("￥"+(Utils.getFoodList().get(position).getPrice() * Utils.getFoodList().get(position).getDiscount()/10.0));
        holder.price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.minFood.setOnClickListener(v->{
            if(Utils.getFoodList().get(position).getAmount()!=0){
                Utils.getFoodList().get(position).setAmount(Utils.getFoodList().get(position).getAmount()-1);
            }
            notifyDataSetChanged();
        });
        holder.addFood.setOnClickListener(v->{
            Utils.getFoodList().get(position).setAmount(Utils.getFoodList().get(position).getAmount()+1);
            notifyDataSetChanged();
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("food",Utils.getFoodList().get(position));
                Navigation.findNavController(v).navigate(R.id.action_foodList_to_foodDetail,bundle);
//                Toast.makeText(context, foodList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Utils.getFoodList().size();
    }

    /**
     * 用来控制每一个item
     */
    static class MyHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView discount;
        public TextView realPrice;
        public TextView price;
        public ImageView minFood;
        public ImageView addFood;
        public TextView amount;
        public ImageView img;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.food_name);
            discount = itemView.findViewById(R.id.food_discount);
            realPrice = itemView.findViewById(R.id.real_price);
            price = itemView.findViewById(R.id.price);
            minFood = itemView.findViewById(R.id.food_min);
            addFood = itemView.findViewById(R.id.food_add);
            amount = itemView.findViewById(R.id.food_amount);
            img = itemView.findViewById(R.id.food_img);
        }
    }

    /**
     * 修改食物数量
     * @param id
     * @param amount
     */
    public static void fixFoodAmount(int id, int amount){
        Utils.getFoodList().get(id).setAmount(amount);
    }
}
