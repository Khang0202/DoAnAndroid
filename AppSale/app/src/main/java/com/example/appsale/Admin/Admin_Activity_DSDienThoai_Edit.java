package com.example.appsale.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appsale.R;

public class Admin_Activity_DSDienThoai_Edit extends AppCompatActivity {
    ImageView pic,btnTroVe;
    VideoView vid;
    EditText id,name,price,num,size,weight,chipset,ram,storage,battery,charging,hangsx;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ds_dienthoai_edit);
        anhXa();
        onClick();
    }
    public void onClick(){
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_Activity_DSDienThoai_Edit.this, AdminActivity_DSDienthoai.class));
            }
        });
    }
    public void anhXa(){
        btnTroVe=findViewById(R.id.backBtn);

        id=findViewById(R.id.edtId);
        name=findViewById(R.id.edtName);
        hangsx=findViewById(R.id.edtHangSX);
        num=findViewById(R.id.edtNum);
        price=findViewById(R.id.edtPrice);
        size=findViewById(R.id.edtSize);
        weight=findViewById(R.id.edtWeight);
        chipset=findViewById(R.id.edtChipset);
        ram=findViewById(R.id.edtRam);
        storage=findViewById(R.id.edtStorage);
        battery=findViewById(R.id.edtPin);
        charging=findViewById(R.id.edtcharging);
        pic=findViewById(R.id.imgPicture);
        vid=findViewById(R.id.vdVideo);
    }
}
