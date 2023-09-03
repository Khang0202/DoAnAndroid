package com.example.appsale.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appsale.Admin.AdminActivity;
import com.example.appsale.R;

public class ProfileActivity extends AppCompatActivity {

    private ImageView avatarImageView;
    private TextView tvUserName, txtPhone, txtChange, txtLichsu, txtGopY, txtChamsoc,txtAdmin;

    private Button btnLogout;
    private String savedUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
        bottom_navigation();
        avatarImageView.setImageResource(R.drawable.ic_avatar);
        txtChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                intent.putExtra("username", tvUserName.getText().toString());
                startActivityForResult(intent,1);

            }
        });
        txtLichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, LichSuActivity.class));
            }
        });
        txtGopY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, FeedBackActivity.class));
            }
        });
        txtChamsoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, CareActivity.class));
            }
        });
        txtAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, AdminActivity.class));
            }
        });
        /*btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                String newUsername = data.getStringExtra("newUsername");
                updateUserInfo(newUsername);
            }
        }
    }
    private void saveUsername() {
        savedUsername = tvUserName.getText().toString();
    }

    private void updateUserInfo(String newUsername) {
        tvUserName.setText(newUsername);
    }
    private void initView() {
        avatarImageView = findViewById(R.id.avatarImageView);
        tvUserName = findViewById(R.id.tvUserName);
        txtPhone = findViewById(R.id.txtPhone);
        btnLogout = findViewById(R.id.btnLogout);
        txtChange = findViewById(R.id.txtChange);
        txtLichsu = findViewById(R.id.txtLichsu);
        txtGopY = findViewById(R.id.txtGopY);
        txtChamsoc = findViewById(R.id.txtChamSoc);
        txtAdmin=findViewById(R.id.txtAdmin);
    }
    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this,MainActivity.class)));
        cartBtn.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this,CartActivity.class)));
        profileBtn.setOnClickListener(v -> startActivity(new Intent(ProfileActivity.this,ProfileActivity.class)));
    }
}