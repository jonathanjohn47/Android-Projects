package com.example.testactivity2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    private AlertDialog.Builder alertdialog;
    private Button goback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        goback = (Button)findViewById(R.id.goBackButton);

        Bundle extra = getIntent().getExtras();
        alertdialog = new AlertDialog.Builder(SecondActivity.this);
        alertdialog.setTitle("Alert! Message from Main Activity");
        alertdialog.setMessage(extra.getString("Message"));
        alertdialog.setCancelable(true);
        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertdialog.show();

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                i.putExtra("Reply", "Hello from Second Activity");
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
