package com.example.appsale.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsale.ObjectClass.User;
import com.example.appsale.R;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.Viewholder>{
    ArrayList<User> items;
    Context context;

    private Bitmap bitmap;

    public UserListAdapter(@NonNull Context context, List<User> manufacturerList) {
        super();
        this.items = (ArrayList<User>) manufacturerList;
        this.context = context;
    }
    public UserListAdapter(ArrayList<User> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_user_list, parent, false);
        context = parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.userId.setText(String.valueOf(items.get(position).getId()));

        holder.firstName.setText(items.get(position).getFirstName());
        holder.lastName.setText(items.get(position).getLastName());
        holder.email.setText(items.get(position).getEmail());
        holder.phone.setText(items.get(position).getPhone());
//        holder.password.setText(items.get(position).getPassword());
        holder.username.setText(items.get(position).getUsername());
        holder.roleName.setText(items.get(position).getRoleName());
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, items.get(position).getEmail(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        TextView firstName,lastName,email,phone,username,password,roleName,userId;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.firstName);
            lastName = itemView.findViewById(R.id.lastName);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            username = itemView.findViewById(R.id.username);
//            password = itemView.findViewById(R.id.password);
            roleName = itemView.findViewById(R.id.roleName);
            userId = itemView.findViewById(R.id.userId);
        }
    }
}
