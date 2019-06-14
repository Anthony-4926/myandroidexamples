package com.example.example02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example02.R;
import com.example.example02.entity.News;

import java.util.List;

/**
 * @author xinzhao
 * @create 2019-05-20 10:11
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyHolder> implements MyCallback.AdapterCallback {

   private List<News> news;

    public MainAdapter(List<News> news) {
        this.news = news;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_news, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.subtitle.setText(news.get(position).subtitle);
        holder.title.setText(news.get(position).title);
        holder.head.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    @Override
    public void remove(int position) {
        news.remove(position);
        notifyItemRemoved(position);
    }

    static class MyHolder extends RecyclerView.ViewHolder{
        public ImageView head;
        public TextView title;
        public TextView subtitle;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            this.head = itemView.findViewById(R.id.news_pic);
            this.title = itemView.findViewById(R.id.news_title);
            this.subtitle = itemView.findViewById(R.id.news_subtitle);
        }
    }
}
