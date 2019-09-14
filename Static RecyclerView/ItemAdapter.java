package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private Context ctx;
    private List<ItemDetails> itemlist;

    public ItemAdapter(Context ctx, List<ItemDetails> itemlist) {
        this.ctx = ctx;
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.layout_view, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemDetails itemDetails = itemlist.get(position);

        holder.name.setText(itemDetails.getName());
        holder.description.setText(itemDetails.getDescription());
        holder.imageView.setImageDrawable(ctx.getResources().getDrawable(itemDetails.getImage()));
    }
    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    /*Another nested class called "ViewHolder"*/
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            name = (TextView)itemView.findViewById(R.id.nameView);
            description = (TextView)itemView.findViewById(R.id.descriptionView);
        }
    }
}
