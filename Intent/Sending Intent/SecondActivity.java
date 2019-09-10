package com.example.testactivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class SecondActivity extends Activity {

    private Button goToSecondActivity;
    private AlertDialog.Builder alertdialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);
        goToSecondActivity = (Button)findViewById(R.id.goToSecondActivity);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            //Toast.makeText(this, extra.getString("Message"), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, extra.getString("Value"), Toast.LENGTH_SHORT).show();

            alertdialog = new AlertDialog.Builder(SecondActivity.this);
            alertdialog.setMessage(extra.getString("Message") + " " + extra.getInt("Value"));
            alertdialog.setTitle("Alert! Messages from Main Activity");
            alertdialog.show();
        }
        goToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                i.putExtra("Message", "Hello from second activity");
                i.putExtra("Second Message","Hello again!");
                startActivity(i);
            }
        });
    }
}
