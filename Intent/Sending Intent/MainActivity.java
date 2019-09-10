package com.example.testactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button goToSecondActivity;
    private AlertDialog.Builder alertdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertdialog = new AlertDialog.Builder(MainActivity.this); //Defining the alert dialog
        Bundle extra = getIntent().getExtras();
        if (extra != null){

            alertdialog.setTitle("Alert! Messages from second activity!");
            alertdialog.setMessage(extra.getString("Message") + " " + extra.getString("Second Message"));
            alertdialog.setCancelable(false);
            alertdialog.show();
        }
        goToSecondActivity = (Button)findViewById(R.id.goToSecondActivity);
        goToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Message", "Hello from First Activity");
                intent.putExtra("Value", 123);
                startActivity(intent);
            }
        });
    }
}
