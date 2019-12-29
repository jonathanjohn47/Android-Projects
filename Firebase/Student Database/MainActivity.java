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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtLoginName, mEdtLoginPassword;
    private Button mBtnLogin;
    private TextView mTxtRegisterHere;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtLoginName = findViewById(R.id.edtName);
        mEdtLoginPassword = findViewById(R.id.edtPassword);

        mBtnLogin = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();

        mTxtRegisterHere = findViewById(R.id.txtRegisterHere);
        mTxtRegisterHere.setOnClickListener(new onTxtRegisterHereClickListener());

        mBtnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    private class BtnLoginClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String email = mEdtLoginName.getText().toString().trim();
            String password = mEdtLoginPassword.getText().toString().trim();

            signIn(email, password);
        }
    }

    private class onTxtRegisterHereClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, RegistrationPage.class);
            startActivity(intent);
            finish();
        }
    }

    private void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user){
        Intent intent = new Intent(MainActivity.this, StudentDetails.class);
        intent.putExtra("Email", user.getEmail());
        intent.putExtra("UID", user.getUid());
        intent.putExtra("Context", "Login Page");
        startActivity(intent);
    }
}
