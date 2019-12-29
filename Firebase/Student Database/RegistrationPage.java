package com.example.jonathan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class RegistrationPage extends AppCompatActivity {

    private EditText mEdtEmail, mEdtRegisterPassword;
    private EditText mEdtConfirmPassword;

    private Button mBtnRegister;

    private TextView mTxtLoginHere;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        init();

        mTxtLoginHere.setOnClickListener(new OnTxtLoginHereListener());
        setOnClickListeners(mBtnRegister, mTxtLoginHere);

    }

    private class OnBtnRegisterClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String email = mEdtEmail.getText().toString();
            String newPassword = mEdtRegisterPassword.getText().toString();
            String confirmpassword = mEdtConfirmPassword.getText().toString();

            if (newPassword.equals(confirmpassword)){
                if (newPassword.length()<6){
                    mt("Password cannot be less than 6 character long");
                }
                else {
                    createAccount(email, newPassword);
                }
            }
            else{
                mt("Passwords should be same!");
            }
        }
    }

    private void mt(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private class OnTxtLoginHereListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RegistrationPage.this, MainActivity.class);
            startActivity(intent);
            //finish();
        }
    }

    private void init(){
        mAuth = FirebaseAuth.getInstance();

        mEdtEmail = findViewById(R.id.edtEmail);

        mEdtRegisterPassword = findViewById(R.id.edtRegisterPassword);

        mEdtConfirmPassword = findViewById(R.id.edtConfirmPassword);

        mTxtLoginHere = findViewById(R.id.txtLoginHere);

        mBtnRegister = findViewById(R.id.btnRegister);

    }

    private void setOnClickListeners(View... views){
        views[0].setOnClickListener(new OnBtnRegisterClickListener());
        views[1].setOnClickListener(new OnTxtLoginHereListener());
    }

    private void createAccount (String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {

                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
                            Log.e("Authentication Error:", e+"");

                            mt("Authentication Failed!");

                        } else {
                            // If sign in fails, display a message to the user.
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            //updateUI(null);
                        }

                        // ...
                    }
                }
        );
    }

    private void updateUI(FirebaseUser user){
        Intent intent = new Intent(RegistrationPage.this, StudentDetails.class);
        intent.putExtra("Email", user.getEmail());
        intent.putExtra("UID", user.getUid());
        intent.putExtra("Context", "Registration Page");
        startActivity(intent);
    }
}
