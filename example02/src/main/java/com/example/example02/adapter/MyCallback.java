package com.example.example02.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author xinzhao
 * @create 2019-05-20 10:40
 */
public class MyCallback extends ItemTouchHelper.Callback {
    public static String stg = "MyCallback";
    private AdapterCallback adapterCallback;

    public interface AdapterCallback{
        void remove(int position);
    }
    public MyCallback(AdapterCallback adapterCallback) {

        this.adapterCallback = adapterCallback;
        Log.d(stg, this.adapterCallback.getClass().toString());
    }




    /**
     * 定义承认的上下拖拽,和左右滑动
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        //允许上下的拖动
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //只允许从右向左侧滑
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(0, swipeFlags);
    }

    /**
     * onMove方法是拖拽的回调，参数viewHolder是拖动的Item，target是拖动的目标位置的Item,
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        switch (direction) {
            case ItemTouchHelper.LEFT:
                Log.d(stg, "咋了呢");
                adapterCallback.equals("hha");
                adapterCallback.remove(viewHolder.getAdapterPosition());
        }
    }

}
