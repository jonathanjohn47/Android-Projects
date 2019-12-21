package com.example.volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserRecyclerViewHolder> {

    private Context mCtx;

    private User[] data;

    public UserRecyclerViewAdapter(Context mCtx, User[] data) {
        this.mCtx = mCtx;
        this.data = data;
    }

    private ImageLoadTask imageLoadTask;
    @NonNull
    @Override
    public UserRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user_layout, null, false);
        return new UserRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerViewHolder holder, int position) {
        User user = data[position];
        holder.mTxtUserName.setText(user.getLogin());
        //imageLoadTask = new ImageLoadTask(holder.mImgUserName, user.getAvatar_url().toString());

        Glide.with(holder.mImgUserName.getContext())
                .load(user.getAvatar_url())
                .into(holder.mImgUserName);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class UserRecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView mTxtUserName;
        private ImageView mImgUserName;
        public UserRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtUserName = itemView.findViewById(R.id.txtUserName);
            mImgUserName = itemView.findViewById(R.id.imgUserImage);
        }
    }
}
