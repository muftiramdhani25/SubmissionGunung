package com.example.submission1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMountAdapter extends RecyclerView.Adapter<ListMountAdapter.ListViewHolder> {
    private ArrayList<Mount> listMount;
    private Context context;

    ListMountAdapter(ArrayList<Mount> list, Context context){
        this.listMount = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ListMountAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_mount, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMountAdapter.ListViewHolder holder, int position) {
        final Mount mount = listMount.get(position);
        Glide.with(holder.itemView.getContext())
                .load(mount.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvName.setText(mount.getName());
        holder.tvFrom.setText(mount.getFrom());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, DetailActivity.class);
                pindah.putExtra(DetailActivity.EXTRA_MOUNT, mount);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMount.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvFrom;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto =itemView.findViewById(R.id.img_item_photo);
            tvName =itemView.findViewById(R.id.tv_item_name);
            tvFrom =itemView.findViewById(R.id.tv_item_from);
        }
    }
}
