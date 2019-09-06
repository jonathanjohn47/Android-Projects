package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
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

        /*textView = (TextView)findViewById(R.id.textView);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton)findViewById(checkedId);
                switch (radioButton.getId()){
                    case R.id.rbyes: {
                        //Do something when "Yes" radio button is clicked
                        textView.setText("Yes");
                    }
                    break;
                    case R.id.rbmaybe: {
                        //Do something when "Maybe" radio button is clicked
                        textView.setText("Maybe");
                    }
                    break;
                    case R.id.rbno: {
                        //Do something when "No" radio button is clicked
                        textView.setText("No");
                    }
                    break;
                }
            }
        });*/
    }

    /*There is another method to detect radio button being checked is by assigning an "OnCLick" to each button,
    * and then creating separate methods/fucntions in java leading to those onclicks*/

    public void yesclick(View v){
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Yes");
    }
    public void maybeclick(View v) {
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Maybe");
    }
    public void noclick(View v){
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("No");
    }
}
