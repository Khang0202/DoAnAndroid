package com.example.appsale.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.appsale.Adapter.CartListAdapter;
import com.example.appsale.Helper.ChangeNumberItemsListener;
import com.example.appsale.Helper.ManagmentCart;
import com.example.appsale.R;

public class CartActivity extends AppCompatActivity {
    double percentTax = 0.08;
    double delivery;
    private RecyclerView.Adapter adapter;
    private EditText edtAddress;
    private RecyclerView recyclerView;
    private ManagmentCart managmentCart;
    private Button btnOrderNow;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;
    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();
        if(managmentCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            btnOrderNow.setVisibility(View.GONE);
            delivery = 0;
        }
        else {
            emptyTxt.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            btnOrderNow.setVisibility(View.VISIBLE);
            delivery = 180;
        }
        initList();
        calcualteCart();
        bottom_navigation();
    }
    private void initView() {
        managmentCart = new ManagmentCart(this);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt  =findViewById(R.id.totalTxt);
        recyclerView = findViewById(R.id.view3);
        scrollView = findViewById(R.id.scrollView3);
        emptyTxt = findViewById(R.id.tvCartEmpty);
        btnOrderNow = (Button) findViewById(R.id.btnOrderNow);
        edtAddress = (EditText) findViewById(R.id.edtAddress);
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managmentCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                if(managmentCart.getListCart().isEmpty()){
                    emptyTxt.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    btnOrderNow.setVisibility(View.GONE);
                    delivery = 0;
                    calcualteCart();
                }
                else {
                    emptyTxt.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    btnOrderNow.setVisibility(View.VISIBLE);
                    delivery = 180;
                    calcualteCart();
                }
            }
        });

        recyclerView.setAdapter(adapter);


    }

    private void calcualteCart() {
        tax = Math.round((managmentCart.getTotalFee()*percentTax*100.0))/100.0;

        double total = Math.round((managmentCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal = Math.round(managmentCart.getTotalFee()*100)/100;

        totalFeeTxt.setText("$"+itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);
    }


    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(CartActivity.this,MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(CartActivity.this,CartActivity.class)));
        profileBtn.setOnClickListener(v -> startActivity(new Intent(CartActivity.this,ProfileActivity.class)));
    }

}