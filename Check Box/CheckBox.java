package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox potato, tomato, cauliflower, broccoli;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        potato = (CheckBox)findViewById(R.id.potato);
        tomato = (CheckBox)findViewById(R.id.tomato);
        cauliflower = (CheckBox)findViewById(R.id.cauliflower);
        broccoli  = (CheckBox)findViewById(R.id.broccoli);
        textView = (TextView)findViewById(R.id.textView);

        String str = textView.getText().toString();
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textView.getText().toString();
                if (potato.isChecked()){
                    str = str + "Potato\n";
                    textView.setText(str);
                }
                else{
                    if (str.contains("Potato")){
                        str = str.replace("Potato\n", "");
                    }
                    textView.setText(str);
                }
            }
        });
        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textView.getText().toString();
                if (tomato.isChecked()){
                    str = str + "Tomato\n";
                    textView.setText(str);
                }
                else{
                    if (str.contains("Tomato")){
                        str = str.replace("Tomato\n", "");
                    }
                    textView.setText(str);
                }
            }
        });
        cauliflower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textView.getText().toString();
                if (cauliflower.isChecked()){
                    str = str + "Cauliflower\n";
                    textView.setText(str);
                }
                else{
                    if (str.contains("Cauliflower")){
                        str = str.replace("Cauliflower\n", "");
                    }
                    textView.setText(str);
                }
            }
        });
        broccoli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textView.getText().toString();
                if (broccoli.isChecked()){
                    str = str + "Broccoli\n";
                    textView.setText(str);
                }
                else{
                    if (str.contains("Broccoli")){
                        str = str.replace("Broccoli\n", "");
                    }
                    textView.setText(str);
                }
            }
        });
    }
}
