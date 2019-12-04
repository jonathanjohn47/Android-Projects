package com.example.fragments2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mAddFragment, mRemoveFragment, mBtnSet;
    private EditText mSetScore;

    private ArrayList<FragmentScoreCounter> mListOfFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSetScore = findViewById(R.id.editTextScore);

        mBtnSet = findViewById(R.id.btnSet);
        mAddFragment = findViewById(R.id.btnAddFragment);
        mRemoveFragment = findViewById(R.id.btnRemoveFragment);

        mListOfFragments = new ArrayList<>();

        mAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentScoreCounter fragmentScoreCounter = new FragmentScoreCounter();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.layoutOfFragments, fragmentScoreCounter);
                mListOfFragments.add(fragmentScoreCounter);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        mRemoveFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.remove(mListOfFragments.get(mListOfFragments.size()-1));
                mListOfFragments.remove(mListOfFragments.size()-1);
                fragmentTransaction.commit();
            }
        });

        mBtnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mListOfFragments.size(); i++) {
                    FragmentScoreCounter fragmentScoreCounter = mListOfFragments.get(i);
                    try {
                        fragmentScoreCounter.setCount(Integer.parseInt(mSetScore.getText().toString()));
                    } catch (NumberFormatException e) {
                        fragmentScoreCounter.setCount(0);
                    }
                }
            }
        });
    }
}
