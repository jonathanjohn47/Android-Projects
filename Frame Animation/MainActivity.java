package com.example.frameanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable batanimation;
    private ImageView batImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batImage = (ImageView)findViewById(R.id.batID);
        batImage.setBackgroundResource(R.drawable.bat_anim);

        batanimation = (AnimationDrawable)batImage.getBackground();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        batanimation.start();
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //stop the animation
                batanimation.stop();
            }
        }, 5000);                         //To run animation parallel to the application
        return super.onTouchEvent(event);
    }
}
