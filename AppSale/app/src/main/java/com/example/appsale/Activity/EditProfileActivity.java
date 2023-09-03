package com.example.appsale.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appsale.R;

public class EditProfileActivity extends AppCompatActivity {
    private EditText edtUsername, edtGioitinh, edtAddress, edtPassword, edtReEnterPassword;
    private Button saveButton;

    private ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initView();
        backBtn.setOnClickListener(v -> startActivity(new Intent(EditProfileActivity.this,ProfileActivity.class)));

        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("username");
            edtUsername.setText(username);
        }


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newUsername", edtUsername.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void initView() {
        edtUsername = findViewById(R.id.edtUsername);
        edtGioitinh = findViewById(R.id.edtGioitinh);
        edtAddress = findViewById(R.id.edtAddress);
        edtPassword = findViewById(R.id.edtPassword);
        edtReEnterPassword = findViewById(R.id.edtRe_enter_password);
        backBtn = findViewById(R.id.backBtn);
        saveButton = findViewById(R.id.saveButton);
    }
}
