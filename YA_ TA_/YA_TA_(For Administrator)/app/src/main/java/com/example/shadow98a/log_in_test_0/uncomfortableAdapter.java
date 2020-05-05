package com.example.shadow98a.log_in_test_0;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class uncomfortableAdapter extends RecyclerView.Adapter<uncomfortableAdapter.CustomViewHolder> {

    private ArrayList<uncomfortableData> mList = null;
    private Activity context = null;

    private String StudentID;

    public uncomfortableAdapter(Activity context, ArrayList<uncomfortableData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected Button list;


        public CustomViewHolder(View view) {
            super(view);
            this.list = (Button) view.findViewById(R.id.textView_list);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.list.setText
                (
                              "\n학번: "+mList.get(position).getMember_StudentID()+
                              "\n접수된 신고: "+mList.get(position).getMember_uncomfortable()
                );
        StudentID=mList.get(position).getMember_StudentID();
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
