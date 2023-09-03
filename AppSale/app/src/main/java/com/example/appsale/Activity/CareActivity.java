package com.example.appsale.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.appsale.R;

public class CareActivity extends AppCompatActivity {

    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);


        initView();
        backBtn.setOnClickListener(v -> startActivity(new Intent(CareActivity.this,ProfileActivity.class)));
    }

    private void initView() {
        backBtn = findViewById(R.id.backBtn);
    }
}