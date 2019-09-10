package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertdialog;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Build and Show the Alert Dialog
                alertdialog = new AlertDialog.Builder(MainActivity.this); //Defining the alert dialog
                alertdialog.setTitle("Alert!");
                alertdialog.setMessage("This is an Alert Dialog that alerts you of nothing.");
                alertdialog.setCancelable(false);
                alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "You Clicked YES",
                                Toast.LENGTH_SHORT).show();

                    }
                });

                        // A null listener allows the button to dismiss the dialog and take no further action.
                alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You clicked NO", Toast.LENGTH_SHORT).show();
                    }
                });
                alertdialog.show();
            }
        });
    }
}
