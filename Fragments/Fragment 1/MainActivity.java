package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtSetScore;
    private Button mBtnSet;
    private FragmentCounter mFragment1, mFragment2;
    //private FragmentCounter mFragmentCounter = new FragmentCounter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSetScore = findViewById(R.id.edtSetScore);
        mBtnSet = findViewById(R.id.btnSet);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mFragment1 = (FragmentCounter) fragmentManager.findFragmentById(R.id.fragment1);
        mFragment2 = (FragmentCounter) fragmentManager.findFragmentById(R.id.fragment2);

        mBtnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer score = Integer.parseInt(mEdtSetScore.getText().toString());
                    mFragment1.setCount(score);
                    mFragment2.setCount(score);
                } catch (NumberFormatException e) {
                    mFragment1.setCount(0);
                    mFragment2.setCount(0);
                    //e.printStackTrace();
                }
            }
        });
    }
}
