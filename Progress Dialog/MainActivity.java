package com.example.progressdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnDowload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mBtnDowload = findViewById( R.id.btnDownload );

        mBtnDowload.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //code to start a download thread

                String  [] urls = {
                        "https://bitcode.in/file1",
                        "https://bitcode.in/file2",
                        "https://bitcode.in/file3"
                };

                new DownloadThread( MainActivity.this, new MyHandler() )
                .execute( urls );
            }
        });
    }

    public void showData ( int progress ){
        mBtnDowload.setText( progress + "%" );
    }

    private class MyHandler extends Handler {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if ( msg != null && msg.obj != null ) {
                if (msg.arg1 == 1) {
                    mBtnDowload.setText(((Integer) msg.obj) + "%");
                }

                if (msg.arg2 == 2) {
                    mBtnDowload.setText(((Float) msg.obj) + "");
                }
            }
        }
    }
}
