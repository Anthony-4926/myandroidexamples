package com.example.example01.adapter;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.example01.R;
import com.example.example01.entity.News;

import java.util.List;

/**
 * @author xinzhao
 * @create 2019-05-17 10:28
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyHolder> {

     private Context context;
    private List<News> news;
    public MainAdapter(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }
    /**
     * 创建一个item，填充布局，放到holder里，返回holder，以后的操作都是基于holder
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_news, viewGroup, false);
        return new MyHolder(itemView);
    }

    /**
     * 通过holder向item中填充内容
     * @param myHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.pic.setImageResource(R.mipmap.ic_launcher);
        myHolder.title.setText(news.get(i).title);
        myHolder.suttitle.setText(news.get(i).title);
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,news.get(i).title , Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    /**
     * 用来控制每一个item
     */
    static class MyHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView suttitle;
        public ImageView pic;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            suttitle = itemView.findViewById(R.id.news_subtitle);
            pic = itemView.findViewById(R.id.news_pic);
        }
    }
}
