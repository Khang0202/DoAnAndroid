package com.example.appsale.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsale.Adapter.PopularListAdapter;
import com.example.appsale.Domain.PopularDomain;
import com.example.appsale.ObjectClass.Manufacturer;
import com.example.appsale.R;
import com.example.appsale.User.UserManufacturerListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView btnSapXepSp;
    private RecyclerView.Adapter adapterPopular,adapterLogoPhone;
    private RecyclerView recyclerViewPopular,recyclerViewListPhone;
    int visible = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        onClick();
        initRecyclerviewListPhone();//New 24/08/2023
        initRecyclerview();
        bottom_navigation();
    }
    //Search Bar ẩn hiện
    private void onClick(){
        ImageView ic_search = findViewById(R.id.ic_search);
        EditText editSearch = findViewById(R.id.editSearch);
        ic_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSearch.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                visible ++;
                if(visible > 1){
                    visible = 0;
                    editSearch.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Visible Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSapXepSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSapXepPopupMenu(v);
            }
        });
    }
    //Glide hình ảnh online
    private void showSapXepPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.sapxepsanpham_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Xử lý khi sắp xếp được chọn
                int choice = item.getItemId();//lưu lựa chọn
                // Thực hiện các xử lý liên quan lựa chọn
                return true;
            }
        });

        popupMenu.show();
    }
    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
        profileBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,ProfileActivity.class)));
    }
    private void initRecyclerviewListPhone() {
        ArrayList<Manufacturer> items = new ArrayList<>();
        String JSON_URL = "http://emlababia123-001-site1.htempurl.com/api/Manufacturer/getAllManufacturer";
        StringRequest sReq = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject manufacturerObject = array.getJSONObject(i);
                        Manufacturer manufacturer = new Manufacturer(
                                manufacturerObject.getString("image")
                        );
                        items.add(manufacturer);
                    }
                    recyclerViewListPhone = findViewById(R.id.recycleListPhone);
                    recyclerViewListPhone.setLayoutManager(new GridLayoutManager(MainActivity.this, 5));
                    adapterLogoPhone = new UserManufacturerListAdapter(items);
                    recyclerViewListPhone.setAdapter(adapterLogoPhone);
                } catch (
                        JSONException e) {
                    Log.w("Load manufacturer", "Error: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(sReq);
    }
    private void initRecyclerview() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("MacBook Pro 13 M2 chip", "8GB",16,10,45 ,"This is the video","Intel i7 10th",512,5,"pic1",10,10,500000,1));
        items.add(new PopularDomain("Ps-5 Digital","8GB",16,10,45 ,"This is the video","Lười search",512,5,"pic2",10,10,500000,2));
        items.add(new PopularDomain("Iphone 14","8GB",16,10,45 ,"This is the video","Lười Search",512,5,"pic3",10,10,500000,3));

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new GridLayoutManager(this, 2));
        adapterPopular = new PopularListAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);

    }
    public void anhXa(){
        btnSapXepSp=findViewById(R.id.btnSapXepSanPham);
    }
}