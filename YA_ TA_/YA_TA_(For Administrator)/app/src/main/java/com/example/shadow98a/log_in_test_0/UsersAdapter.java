package com.example.shadow98a.log_in_test_0;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> {

    private ArrayList<PersonalData> mList = null;
    private Activity context = null;

    private String StudentID;

    public UsersAdapter(Activity context, ArrayList<PersonalData> list) {
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
                        (((mList.get(position).getMember_VehicleID()).equals("USER"))? "USER":"DRIVER")+
                              "\n학번: "+mList.get(position).getMember_StudentID()+
                              "\n비밀번호: "+mList.get(position).getMember_Pwd()+
                              "\n이름: "+mList.get(position).getMember_Name()+
                              "\n전화번호: "+mList.get(position).getMember_Phone()+
                                (((mList.get(position).getMember_VehicleID()).equals("USER"))? "":
                              "\n차량번호: "+mList.get(position).getMember_VehicleID())

                );
        StudentID=mList.get(position).getMember_StudentID();
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
