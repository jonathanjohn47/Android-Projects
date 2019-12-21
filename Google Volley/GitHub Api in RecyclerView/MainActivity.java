package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> allUsers;

    private RecyclerView mUserListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allUsers = new ArrayList<>();

        mUserListRecyclerView = findViewById(R.id.userRecyclerViews);
        mUserListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String url = "https://api.github.com/users";

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Code", response);

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        User[] users = gson.fromJson(response, User[].class);
                        for (User u: users) {
                            allUsers.add(u);
                        }
                        mUserListRecyclerView.setAdapter(new UserRecyclerViewAdapter(MainActivity.this, users));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error+"");
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void mt(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT)
                .show();
    }
}
