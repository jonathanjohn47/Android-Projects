package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentCounter extends Fragment {

    private TextView mTxtScore;
    private Button mBtnPlus, mBtnMinus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.counter_fragment, null);
        mTxtScore = view.findViewById(R.id.txtCounter);
        mTxtScore.setText(0+"");
        mBtnPlus = view.findViewById(R.id.btnPlus);
        mBtnMinus = view.findViewById(R.id.btnMinus);

        mBtnPlus.setOnClickListener(new onBtnPlusClickListener());
        mBtnMinus.setOnClickListener(new onBtnMinusClickListener());
        return view;
    }

    private class onBtnPlusClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            mTxtScore.setText((Integer.parseInt(mTxtScore.getText().toString()) + 1) + "");
        }
    }

    private class onBtnMinusClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            mTxtScore.setText((Integer.parseInt(mTxtScore.getText().toString()) - 1)+"");
        }
    }

    public void setCount(int count){
        mTxtScore.setText(count+"");
    }
}
