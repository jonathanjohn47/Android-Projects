package com.example.backgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Switch mSwtich;
    private Button mStart, mStop;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwtich = (Switch)findViewById(R.id.switch1);
        mStart = findViewById(R.id.btnStart);
        mStop = findViewById(R.id.btnStop);
        textView = findViewById(R.id.textView);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ExampleThread exampleThread = new ExampleThread(500);
                exampleThread.start();*/

                ExampleRunnable runnable = new ExampleRunnable(1000);
                new Thread(runnable).start();
            }
        });
    }

    private void startThread (int seconds){
        for (int i=0; i<=10; i++){
            try{
                Thread.sleep(seconds);
                Log.d("Printing", i+"");
                //textView.setText(i+"");
            }catch (InterruptedException e){}
        }
    }

    class ExampleThread extends Thread{

        public ExampleThread(int seconds) {
            this.seconds = seconds;
        }

        int seconds;

        @Override
        public void run() {
            startThread(seconds);
        }
    }
    class ExampleRunnable implements Runnable{
        public ExampleRunnable(int seconds) {
            this.seconds = seconds;
        }

        int seconds;
        @Override
        public void run() {
            startThread(seconds);
        }
    }
}
