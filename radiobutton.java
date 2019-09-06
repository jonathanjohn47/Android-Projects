package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton)findViewById(checkedId);
                switch (radioButton.getId()){
                    case R.id.rbyes: {
                        /*Do something when "Yes" radio button is clicked*/
                        textView.setText("Yes");
                    }
                    break;
                    case R.id.rbmaybe: {
                        /*Do something when "Maybe" radio button is clicked*/
                        textView.setText("Maybe");
                    }
                    break;
                    case R.id.rbno: {
                        /*Do something when "No" radio button is clicked*/
                        textView.setText("No");
                    }
                    break;
                }
            }
        });
    }
}
