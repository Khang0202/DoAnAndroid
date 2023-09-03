package com.example.appsale.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appsale.R;

public class Admin_Activity_DSUsers_Edit extends AppCompatActivity {
    ImageView btnTroVe;
    EditText id,ten,ho,email,phone,username,password,createDate,active,roleId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ds_user_edit);
        anhXa();
        onClick();
    }
    public void onClick(){
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Activity_DSUsers_Edit.this, AdminActivity_DSUsers.class));
            }
        });
    }
    public void anhXa(){
        btnTroVe=findViewById(R.id.backBtn);

        id=findViewById(R.id.edtId);
        ten=findViewById(R.id.edtFistName);
        ho=findViewById(R.id.edtLastName);
        email=findViewById(R.id.edtEmail);
        phone=findViewById(R.id.edtPhone);
        username=findViewById(R.id.edtTaiKhoan);
        password=findViewById(R.id.edtMatKhau);
        createDate=findViewById(R.id.edtCreatDate);
        active=findViewById(R.id.edtActive);
        roleId=findViewById(R.id.edtRoleID);

    }
}
