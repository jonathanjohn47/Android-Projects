package com.example.fragments2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentScoreCounter extends Fragment {

    private TextView mTxtScore;
    private Button mBtnIncrement, mBtnDecrement;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, null);

        mTxtScore = view.findViewById(R.id.txtScore);
        mBtnIncrement = view.findViewById(R.id.btnIncrement);
        mBtnDecrement = view.findViewById(R.id.btnDecrement);

        mTxtScore.setText(0+"");

        mBtnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int i = Integer.parseInt(mTxtScore.getText().toString());
                    mTxtScore.setText((i + 1) + "");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        mBtnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int i = Integer.parseInt(mTxtScore.getText().toString());
                    mTxtScore.setText((i - 1) + "");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

    public void setCount(int i){
        try {
            mTxtScore.setText(i + "");
        } catch (NullPointerException e) {
            mTxtScore.setText(0+"");
        }
    }
}
