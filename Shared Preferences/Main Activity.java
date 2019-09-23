package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private TextView result;
    private EditText entermessage;
    private SharedPreferences myprefs;
    private static final String PREFS_NAME = "My Prefs File";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entermessage = (EditText)findViewById(R.id.name);
        saveButton = (Button)findViewById(R.id.saveButton);
        result = (TextView)findViewById(R.id.result);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myprefs = getSharedPreferences(PREFS_NAME, 0); //0 refers to whether the file is accessible
                SharedPreferences.Editor editor = myprefs.edit();

                editor.putString("Message", entermessage.getText().toString());
                editor.commit();
            }
        });

        //To get data back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        if (prefs.contains("Message")){
            String message = prefs.getString("Message", "Not found!");
            result.setText("Message: " + message);
        }
    }
}
