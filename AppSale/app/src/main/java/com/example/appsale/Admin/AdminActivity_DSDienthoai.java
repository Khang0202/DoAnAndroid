package com.example.appsale.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsale.Adapter.PopularListAdapter;
import com.example.appsale.Domain.PopularDomain;
import com.example.appsale.R;

import java.util.ArrayList;

public class AdminActivity_DSDienthoai extends AppCompatActivity {
    ImageView btnBack;
    TextView btnThem,btnSua,btnXoa;
    private RecyclerView.Adapter adapterDienThoai;
    private RecyclerView recyclerViewDienThoai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ds_dienthoai);
        anhXa();
        initRecyclerview();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity_DSDienthoai.this, AdminActivity.class));
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity_DSDienthoai.this, Admin_Activity_DSDienThoai_Edit.class));
            }
        });
    }
    public void anhXa(){
        btnBack=findViewById(R.id.backBtn);
        btnThem=findViewById(R.id.btnThemDienThoai);
        btnSua=findViewById(R.id.btnSuaDienThoai);
        btnXoa=findViewById(R.id.btnXoaDienThoai);
    }
    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("MacBook Pro 13 M2 chip", "8GB",16,10,45 ,"This is the video","Intel i7 10th",512,5,"pic1",10,10,500000,1));
        items.add(new PopularDomain("Ps-5 Digital","8GB",16,10,45 ,"This is the video","Lười search",512,5,"pic2",10,10,500000,2));
        items.add(new PopularDomain("Iphone 14","8GB",16,10,45 ,"This is the video","Lười Search",512,5,"pic3",10,10,500000,3));

        recyclerViewDienThoai = findViewById(R.id.DanhSachDienThoai);
        recyclerViewDienThoai.setLayoutManager(new GridLayoutManager(this, 2));
        adapterDienThoai = new PopularListAdapter(items);
        recyclerViewDienThoai.setAdapter(adapterDienThoai);
    }
}

