package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.DetailsActivity;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import Model.ListItem;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> listitems;

    /*-----------The constructor-----------------*/
    public myAdapter(Context context, List<ListItem> listitems) {
        this.context = context;
        this.listitems = listitems;
    }

    /*------------The Three Methods--------------*/
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view, context, (ArrayList<ListItem>) listitems);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.ViewHolder holder, int position) {
        ListItem item = listitems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_background));
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }
    //--------------------Inner Class ViewHolder-----------------//
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name, description;
        public ImageView image;
        public ViewHolder(@NonNull View itemView, Context context, ArrayList<ListItem> listitems) {
            super(itemView);
            listitems = listitems;
            context = context;

            itemView.setOnClickListener(this);
            name = (TextView)itemView.findViewById(R.id.nameview);
            description = (TextView)itemView.findViewById(R.id.descriptionview);
            image = (ImageView)itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ListItem item = listitems.get(position);

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("Name", item.getName());
            intent.putExtra("Description", item.getDescription());
            context.startActivity(intent);
            Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
