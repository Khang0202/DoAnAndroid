package com.example.appsale.User;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.appsale.ObjectClass.Manufacturer;
import com.example.appsale.R;

import java.util.ArrayList;
import java.util.List;

public class UserManufacturerListAdapter extends RecyclerView.Adapter<UserManufacturerListAdapter.Viewholder>{
    ArrayList<Manufacturer> items;
    Context context;

    private Bitmap bitmap;

    public UserManufacturerListAdapter(@NonNull Context context, List<Manufacturer> manufacturerList) {
        super();
        this.items = (ArrayList<Manufacturer>) manufacturerList;
        this.context = context;
    }
    public UserManufacturerListAdapter(ArrayList<Manufacturer> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_manufacturer_list, parent, false);
        context = parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.manufacturerId.setText(String.valueOf(items.get(position).getId()));

        holder.nameManufacturer.setText(items.get(position).getName());
        Glide.with(context).load(items.get(position).getImage())
                .transform(new GranularRoundedCorners(0,0,0,0))
                .into(holder.imageManufacturer);
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Clicked " + position, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imageManufacturer; TextView nameManufacturer,manufacturerId;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nameManufacturer = itemView.findViewById(R.id.nameManufacturer);
            manufacturerId = itemView.findViewById(R.id.manufacturerId);

            imageManufacturer = itemView.findViewById(R.id.imageManufacturer);
        }
    }
}
