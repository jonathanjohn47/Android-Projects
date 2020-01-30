package com.iiysoftware.academy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtStudentName, mEdtVisitorName, mEdtClass, mEdtSection, mEdtRollNo, mEdtPhoneNumber, mPurposeOfVisit;
    private Button mBtnVerify;

    private FirebaseAuth mAuth;

    private String mVerificationId;
    private String PhoneNumber;

    //private DatabaseReference myRef;

    private String studentname;
    private String visitorname;
    private String studentclass;
    private String section;
    private String rollno;
    private String phonenumber;

    private FrameLayout frameLayout;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        
        mBtnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyPhoneNumber();
            }
        });
    }

    private boolean checkForEmptyEditTexts() {
        String studentname = mEdtStudentName.getText().toString();
        String visitorname = mEdtVisitorName.getText().toString();
        String studentclass = mEdtClass.getText().toString();
        String studentsection = mEdtSection.getText().toString();
        String studentrollno = mEdtRollNo.getText().toString();
        String visitorphonenumber = mEdtPhoneNumber.getText().toString();
        String purposeofvisit = mPurposeOfVisit.getText().toString();

        if (studentname.equals("")){
            animate(mEdtStudentName);
            mEdtStudentName.requestFocus();
            return false;
        }else if (visitorname.equals("")){
            animate(mEdtVisitorName);
            mEdtVisitorName.requestFocus();
            return false;
        }else if (studentclass.equals("")){
            animate(mEdtClass);
            mEdtClass.requestFocus();
            return false;
        }else if (studentsection.equals("")){
            animate(mEdtSection);
            mEdtSection.requestFocus();
            return false;
        }else if (studentrollno.equals("")){
            animate(mEdtRollNo);
            mEdtRollNo.requestFocus();
            return false;
        }else if (visitorphonenumber.equals("")){
            animate(mEdtPhoneNumber);
            mEdtPhoneNumber.requestFocus();
            return false;
        }else if (purposeofvisit.equals("")){
            animate(mPurposeOfVisit);
            mPurposeOfVisit.requestFocus();
            return false;
        }else {return true;}
    }

    private void verifyPhoneNumber() {
        boolean anyEmptyText = checkForEmptyEditTexts();
        if (anyEmptyText==false){return;}
        else {
            String phNo = mEdtPhoneNumber.getText().toString();
            if (phNo.length() != 10) {
                mt("Please enter a valid 10 digit phone number");
            } else {
                phNo = "+91" + phNo;
            }
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phNo,        // Phone number to verify
                    60,                 // Timeout duration
                    TimeUnit.SECONDS,   // Unit of timeout
                    this,               // Activity (for callback binding)
                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        }

                        @Override
                        public void onVerificationFailed(FirebaseException e) {
                            mt("Verification Failed!");
                        }

                        @Override
                        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            mVerificationId = s;
                        }
                    });

            final OTPVerification otpVerification = new OTPVerification(MainActivity.this);
            otpVerification.setmBtnVerifyListener(new OTPVerification.BtnVerifyListener() {
                @Override
                public void onVerify() {
                    String enteredotp = otpVerification.enterOTP.getText().toString();
                    verifyVerificationCode(enteredotp);
                    otpVerification.dismiss();
                }
            });
            otpVerification.show();
        }
    }

    private void verifyVerificationCode(String enteredotp) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, enteredotp);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            saveAllData();
                        } else {
                            // Sign in failed, display a message and update the UI
                            mt("Incorrect OTP");
                        }
                    }
                });
    }

    private void saveAllData() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy / HH:mm:ss");
        String dateAndTimeOfVisit = simpleDateFormat.format(date);

        String studentname = mEdtStudentName.getText().toString();
        String visitorname = mEdtVisitorName.getText().toString();
        String studentclass = mEdtClass.getText().toString();
        String studentsection = mEdtSection.getText().toString();
        String studentrollno = mEdtRollNo.getText().toString();
        String visitorphonenumber = mEdtPhoneNumber.getText().toString();
        String purposeofvisit = mPurposeOfVisit.getText().toString();
        VisitorModel model = new VisitorModel(studentname, visitorname, studentclass, studentsection, studentrollno, visitorphonenumber, dateAndTimeOfVisit, purposeofvisit);
        db.collection("Visitors")
                .document(dateAndTimeOfVisit.split("/")[0])
                .collection(dateAndTimeOfVisit.split("/")[1])
                .document("List")
                .set(model);

        mt("All Data Saved");
    }

    private void mt(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void init() {
        mEdtStudentName = findViewById(R.id.edtStudentsName);
        mEdtVisitorName = findViewById(R.id.edtNameVisitor);
        mEdtClass = findViewById(R.id.edtClass);
        mEdtSection = findViewById(R.id.edtSection);
        mEdtRollNo = findViewById(R.id.edtRollNo);
        mEdtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        mBtnVerify = findViewById(R.id.btnVerify);
        mAuth = FirebaseAuth.getInstance();
        mPurposeOfVisit = findViewById(R.id.edtPurposeOfVisit);
        frameLayout = findViewById(R.id.main_activity_intro_frame_layout);
        db = FirebaseFirestore.getInstance();
    }

    private void animate(View view){
        YoYo.with(Techniques.Pulse)
                .duration(200)
                .repeat(1)
                .playOn(view);
    }
}
