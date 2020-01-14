package com.IIYSoftware.otpauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtStudentName, mEdtVisitorName, mEdtClass, mEdtSection, mEdtRollNo, mEdtPhoneNumber;
    private Button mBtnVerify;

    private FirebaseAuth mAuth;

    private String mVerificationId;
    private String PhoneNumber;

    private DatabaseReference myRef;

    private String studentname;
    private String visitorname;
    private String studentclass;
    private String section;
    private String rollno;
    private String phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mBtnVerify.setOnClickListener(new BtnVerifyClickListener());
    }

    private void init(){
        mEdtStudentName = findViewById(R.id.edtStudentsName);
        mEdtVisitorName = findViewById(R.id.edtNameVisitor);
        mEdtClass = findViewById(R.id.edtClass);
        mEdtSection = findViewById(R.id.edtSection);
        mEdtRollNo = findViewById(R.id.edtRollNo);
        mEdtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        mBtnVerify = findViewById(R.id.btnVerify);
        myRef = FirebaseDatabase.getInstance().getReference("Visitors");
        mAuth = FirebaseAuth.getInstance();
    }

    private class BtnVerifyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            studentname = mEdtStudentName.getText().toString();
            visitorname = mEdtVisitorName.getText().toString();
            studentclass = mEdtClass.getText().toString();
            section = mEdtSection.getText().toString();
            rollno = mEdtRollNo.getText().toString();
            phonenumber = mEdtPhoneNumber.getText().toString();

            if (studentname.isEmpty()||visitorname.isEmpty()||studentclass.isEmpty()||section.isEmpty()||rollno.isEmpty()||phonenumber.isEmpty()){
                if (studentname.isEmpty()){
                    animate(mEdtStudentName);
                    mEdtStudentName.requestFocus();
                }
                else if (visitorname.isEmpty()){
                    animate(mEdtVisitorName);
                    mEdtVisitorName.requestFocus();
                }
                else if (studentclass.isEmpty()){
                    animate(mEdtClass);
                    mEdtClass.requestFocus();
                }
                else if (section.isEmpty()){
                    animate(mEdtSection);
                    mEdtSection.requestFocus();
                }
                else if (rollno.isEmpty()){
                    animate(mEdtRollNo);
                    mEdtRollNo.requestFocus();
                }
                else if (phonenumber.isEmpty()){
                    animate(mEdtPhoneNumber);
                    mEdtPhoneNumber.requestFocus();
                }
                return;
            }
            else {
                if (phonenumber.length()!= 10){
                    mt("Please enter valid phone number");
                }
                else {

                    PhoneNumber = "+91" + mEdtPhoneNumber.getText().toString();
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            PhoneNumber,
                            60,
                            TimeUnit.SECONDS,
                            TaskExecutors.MAIN_THREAD,
                            verificationCallBacks);

                    final OTPVerification otpVerification = new OTPVerification(MainActivity.this);
                    otpVerification.setmBtnVerifyListener(new OTPVerification.BtnVerifyListener() {
                        @Override
                        public void onVerify() {
                            String enteredOTP = otpVerification.enterOTP.getText().toString();
                            verifyVerificationCode(enteredOTP);
                            otpVerification.dismiss();
                        }
                    });
                    otpVerification.show();
                }
            }
        }
    }

    private void verifyVerificationCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                mt("Correct OTP");
                                saveallData();
                            }
                            else{
                                mt("Incorrect OTP");
                            }
                    }
                });
    }

    private void saveallData() {

        Visitor visitor = new Visitor(studentname, visitorname, studentclass, section, rollno, phonenumber);
        writeNewVisitor(visitor);

        mt("Visitor's details saved.");
    }

    private void writeNewVisitor(Visitor visitor){
        DateFormat df = new SimpleDateFormat("dd MMMM yy / HH:mm:ss");
        Date dateobj = new Date();
        log(df.format(dateobj));
        DatabaseReference myChildRef = myRef.child(df.format(dateobj));
        myChildRef.setValue(visitor);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks verificationCallBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            //mVerificationId = phoneAuthCredential.getSmsCode();
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            mt("Verification failed");
            log(e+"");
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            //super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;
            //log(s);
        }
    };

    private void mt(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    private void log(String text){
        Log.e("Error", text);
    }

    private String randomOTPGenerator(){
        Random r = new Random();
        long digit = r.nextInt(90000);
        long otp = digit + 10000;
        String OTP = String.valueOf(otp);
        return OTP;
    }

    private void animate(View view){
        YoYo.with(Techniques.Bounce)
                .repeat(0)
                .playOn(view);
    }
}
