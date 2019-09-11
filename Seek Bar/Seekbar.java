package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textView, status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.seekbar);
        textView = (TextView)findViewById(R.id.textView);
        status = (TextView)findViewById(R.id.status);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getProgress()<7){
                    textView.setTextColor(Color.GRAY);
                    textView.setText("User Ratings: " + seekBar.getProgress() + "/" + seekBar.getMax());
                }
                else
                {
                    if(seekBar.getProgress()<9){
                        textView.setTypeface(null, Typeface.NORMAL);
                        textView.setTextColor(Color.RED);
                        textView.setText("User Ratings: " + seekBar.getProgress() + "/" + seekBar.getMax());
                    }
                    else if (seekBar.getProgress()<10)
                    {
                        textView.setTextColor(Color.RED);
                        textView.setTypeface(null, Typeface.BOLD);
                        textView.setText("User Ratings: " + seekBar.getProgress() + "/" + seekBar.getMax());
                    }
                    else
                    {
                        textView.setTextColor(Color.RED);
                        textView.setTypeface(null, Typeface.BOLD);

                        textView.setText("USER RATINGS: " + seekBar.getProgress() + "/" + seekBar.getMax());
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                status.setText("Adjusting");
                Log.d("SB", "On Start Tracking Touch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                status.setText("Finished!");
                Log.d("SB", "On Stop");
            }
        });
    }
}
