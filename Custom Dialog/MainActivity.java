package com.example.customdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                loginDialog.setOnLoginListener(new LoginDialog.onLoginListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        loginDialog.dismiss();
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });

                loginDialog.show();
            }
        });
    }
}
