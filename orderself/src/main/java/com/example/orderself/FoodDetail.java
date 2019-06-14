package com.example.orderself;


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
        ImageView img = getActivity().findViewById(R.id.food_detail_img);
        TextView price = getActivity().findViewById(R.id.food_detail_price);
        TextView element = getActivity().findViewById(R.id.food_detail_element);
        TextView intro = getActivity().findViewById(R.id.food_detail_intro);
        Food food = (Food)getArguments().get("food");
        img.setImageResource(food.getImg());
        price.setText(""+food.getPrice()*food.getDiscount()/10);
//        element.setText(food.getelement);
        intro.setText(food.getIntro());
    }
}
