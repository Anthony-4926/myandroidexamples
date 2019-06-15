package com.example.orderself;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderself.adapter.FoodListAdapter;
import com.example.orderself.entity.Food;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodDetail extends Fragment {


    public FoodDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        拿到食物详情页面的所有内容
        ImageView img = getActivity().findViewById(R.id.food_detail_img);
        TextView price = getActivity().findViewById(R.id.food_detail_price);
        TextView element = getActivity().findViewById(R.id.food_detail_element);
        TextView intro = getActivity().findViewById(R.id.food_detail_intro);
        ImageView addFood = getActivity().findViewById(R.id.detail_food_add);
        ImageView minFood = getActivity().findViewById(R.id.detail_food_min);
        TextView amount = getActivity().findViewById(R.id.detail_food_amount);
//        从baudle获取参数，渲染到页面
        Food food = (Food)getArguments().get("food");
        img.setImageResource(food.getImg());
        price.setText(""+food.getPrice()*food.getDiscount()/10);
//        element.setText(food.getelement);
        intro.setText(food.getIntro());
        amount.setText(""+food.getAmount());

//        设置监听，增加和减少食物
        addFood.setOnClickListener(v->{
            int newAmount = Integer.valueOf(amount.getText().toString())+1;
            amount.setText(""+ newAmount);
            FoodListAdapter.fixFoodAmount(food.getId(), newAmount);
        });

        minFood.setOnClickListener(v->{
            if(amount.getText().toString()!="0"){
                int newAmount = Integer.valueOf(amount.getText().toString())-1;
                amount.setText(""+ newAmount);
                FoodListAdapter.fixFoodAmount(food.getId(), newAmount);
            }
        });
    }
}
