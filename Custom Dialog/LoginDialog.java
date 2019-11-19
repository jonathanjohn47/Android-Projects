package com.example.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {

    Context mCtx;
    private Button mBtnSignIn;
    private EditText mEdtUserName, mEdtPassword;

    public interface onLoginListener{
        void onSuccess();
        void onFailure();
    }

    private onLoginListener onLoginListener;

    public void setOnLoginListener(LoginDialog.onLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(@NonNull Context mCtx) {
        super(mCtx);
        this.mCtx = mCtx;

        setContentView(R.layout.login_dialog);
        mBtnSignIn = findViewById(R.id.btnSignIn);
        mEdtPassword = findViewById(R.id.edtPassword);
        mEdtUserName = findViewById(R.id.edtUserName);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLoginListener==null){
                    return;
                }
                if (mEdtUserName.getText().toString().equals("JJ") && mEdtPassword.getText().toString().equals("56")){
                    onLoginListener.onSuccess();
                }
                else{
                    onLoginListener.onFailure();
                }
            }
        });
    }


}
