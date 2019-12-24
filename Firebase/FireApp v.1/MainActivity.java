package com.example.fireapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;

    private Firebase mRootRef;

    private ArrayList<User> mListOfAllUsers;
    private UsersRecyclerViewAdapter adapter;
    private RecyclerView mRecyclerView;

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListOfAllUsers = new ArrayList<>();

        mRecyclerView = findViewById(R.id.userRecyclerView);
        adapter = new UsersRecyclerViewAdapter(mListOfAllUsers);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFrameLayout = findViewById(R.id.frameLayout);

        mRootRef = new Firebase("https://fireapp-ac271.firebaseio.com/Users");
        mSendData = findViewById(R.id.btnSendData);

        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserListFragment userListFragment = new UserListFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frameLayout, userListFragment);
                fragmentTransaction.commit();
            }
        });

    }
}
