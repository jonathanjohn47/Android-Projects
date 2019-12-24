package com.example.fireapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersRecyclerViewAdapter extends RecyclerView.Adapter<UsersRecyclerViewAdapter.MyViewHolder> {

    public UsersRecyclerViewAdapter(ArrayList<User> mListOfUsers) {
        this.mListOfUsers = mListOfUsers;
    }

    private ArrayList<User> mListOfUsers;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_inflater, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mListOfUsers.get(position);
        holder.txtName.setText(user.getName());
        holder.txtAge.setText(user.getAge());
    }

    @Override
    public int getItemCount() {
        return mListOfUsers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName, txtAge;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
        }
    }
}