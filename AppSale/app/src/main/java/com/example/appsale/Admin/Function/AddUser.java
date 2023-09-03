package com.example.appsale.Admin.Function;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appsale.Admin.AdminActivity_DSUsers;
import com.example.appsale.R;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class AddUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText txtHo, txtTen, txtExmail, txtPhone, txtUsername, txtPassword;
    private TextView btnThemUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        anhXa();
        onClick();

    }

    private void onClick() {
        btnThemUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ThemMoi();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }

    private void anhXa() {
        txtHo = findViewById(R.id.txtHo);
        txtTen = findViewById(R.id.txtTen);
        txtExmail = findViewById(R.id.txtExmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnThemUser = findViewById(R.id.btnThemUser);

    }

    public void ThemMoi2( ) {
        String txtHo = this.txtHo.getText().toString().trim();
        String txtTen = this.txtTen.getText().toString().trim();
        String txtExmail = this.txtExmail.getText().toString().trim();
        String txtPhone = this.txtPhone.getText().toString().trim();
        String txtUsername = this.txtUsername.getText().toString().trim();
        String txtPassword = this.txtPassword.getText().toString().trim();
        if (txtHo.equals("") || txtTen.equals("") || txtExmail.equals("") || txtPhone.equals("")
                || txtUsername.equals("") || txtPassword.equals("")) {
            Toast.makeText(getApplicationContext(), "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        } else {
            String JSON_URL = "http://emlababia123-001-site1.htempurl.com/api/User/register";

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.PUT, JSON_URL,
                    new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("Response", response.toString());

                    if (response.equals("1")) {
                        Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(getApplicationContext(), AdminActivity_DSUsers .class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Lỗi " + error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("first_name", txtHo);
                    param.put("last_name", txtTen);
                    param.put("email", txtExmail);
                    param.put("phone", txtPhone);
                    param.put("user_name", txtUsername);
                    param.put("password", txtPassword);
                    return param;
                }
            };
            requestQueue.add(stringRequest);

        }
    }
    public void ThemMoi() throws JSONException {

        String rp ="";
        String txtHo = this.txtHo.getText().toString();
        String txtTen = this.txtTen.getText().toString();
        String txtExmail = this.txtExmail.getText().toString();
        String txtPhone = this.txtPhone.getText().toString();
        String txtUsername = this.txtUsername.getText().toString();
        String txtPassword = this.txtPassword.getText().toString();
        if (txtHo.equals("") || txtTen.equals("") || txtExmail.equals("") || txtPhone.equals("")
                || txtUsername.equals("") || txtPassword.equals("")) {
            Toast.makeText(getApplicationContext(), "Vui lòng điền đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        } else {
            try {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("first_name", txtHo);
                jsonObject.put("last_name", txtTen);
                jsonObject.put("email", txtExmail);
                jsonObject.put("phone", String.valueOf(txtPhone));
                jsonObject.put("user_name", txtUsername);
                jsonObject.put("password", txtPassword);

                Log.d("jsonObject", String.valueOf( jsonObject));

                RequestQueue queue = Volley.newRequestQueue(this);

                String JSON_URL = "http://emlababia123-001-site1.htempurl.com/api/User/register";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, JSON_URL,jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("Response", response.toString());
                                if (response.equals(1)) {
                                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                                    finish();
                                    startActivity(new Intent(AddUser.this, AdminActivity_DSUsers.class));
                                } else {
                                    Log.d("Response", response.toString());
                                    Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.w("onErrorResponse", error.toString());
                                Toast.makeText(getApplicationContext(), "Lỗi " + error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });

                queue.add(jsonObjectRequest);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}