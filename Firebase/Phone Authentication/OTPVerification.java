package com.iiysoftware.academy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class OTPVerification extends Dialog {
    Context context;
    public EditText enterOTP;
    private Button verify;

    public OTPVerification(@NonNull Context context) {
        super(context);
        this.context = context;

        setContentView(R.layout.otp_verification_dialog);

        enterOTP = findViewById(R.id.edtEnterOTP);
        verify = findViewById(R.id.btnOTPSubmit);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnVerifyListener!=null){
                    mBtnVerifyListener.onVerify();
                }
            }
        });
    }

    public interface BtnVerifyListener{
        void onVerify();
    }

    private BtnVerifyListener mBtnVerifyListener;

    public void setmBtnVerifyListener(BtnVerifyListener mBtnVerifyListener) {
        this.mBtnVerifyListener = mBtnVerifyListener;
    }
}
