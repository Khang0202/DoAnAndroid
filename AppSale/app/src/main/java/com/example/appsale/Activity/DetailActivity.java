package com.example.appsale.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appsale.Domain.PopularDomain;
import com.example.appsale.Helper.ManagmentCart;
import com.example.appsale.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn, buyNow;
    private TextView titleTxt, feeTxt, reviewTxt, scoreTxt;
    private TextView tvSize, tvWeight, tvChipset, tvRam, tvStorage, tvBattery, tvVideo, tvCharging;
    private ImageView picItem, backBtn;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managmentCart = new ManagmentCart(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$" + object.getPrice());
        reviewTxt.setText(String.valueOf(object.getReview()));
        scoreTxt.setText(String.valueOf(object.getScore()));

        tvRam.setText(object.getRam());
        tvWeight.setText(String.valueOf(object.getWeight()));
        tvStorage.setText(String.valueOf(object.getStorage()));
        tvVideo.setText(object.getVideo());
        tvChipset.setText(object.getChipSet());
        tvSize.setText(String.valueOf(object.getSize()));
        tvCharging.setText(String.valueOf(object.getCharging()));
        tvBattery.setText(String.valueOf(object.getBattery()));

        addToCartBtn.setOnClickListener(v -> {
            object.setNumberInCart(numberOrder);
            managmentCart.insertFood(object);
        });

        buyNow.setOnClickListener(v -> {
            object.setNumberInCart(numberOrder);
            managmentCart.insertFood(object);
            startActivity(new Intent(DetailActivity.this, CartActivity.class));
        });

        backBtn.setOnClickListener(v -> finish());
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        buyNow = findViewById(R.id.buyNow);
        feeTxt = findViewById(R.id.priceTxt);
        titleTxt = findViewById(R.id.titleTxt);
        picItem = findViewById(R.id.itemPic);
        reviewTxt = findViewById(R.id.reviewTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        backBtn = findViewById(R.id.backBtn);

        tvSize = findViewById(R.id.tvSize);
        tvBattery = findViewById(R.id.tvBattery);
        tvCharging = findViewById(R.id.tvCharging);
        tvRam = findViewById(R.id.tvRam);
        tvChipset = findViewById(R.id.tvChipset);
        tvVideo = findViewById(R.id.tvVideo);
        tvStorage = findViewById(R.id.tvStorage);
        tvWeight = findViewById(R.id.tvWeight);
    }
}
