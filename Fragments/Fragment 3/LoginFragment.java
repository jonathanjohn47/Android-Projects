package com.example.fragment3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private Button mBtnLogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, null);
        mBtnLogin = view.findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onLoginListener!=null){
                    onLoginListener.loginClick();
                }
            }
        });
        return view;
    }

    public interface onLoginListener{
        void loginClick();
    }

    public void setOnLoginListener(LoginFragment.onLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    private onLoginListener onLoginListener;
}
