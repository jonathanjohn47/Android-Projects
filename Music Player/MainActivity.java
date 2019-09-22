package com.example.musicplayer;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.channels.CompletionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private Button play, previous, next;
    private MediaPlayer mediaPlayer;
    private TextView leftTime, rightTime;
    private Handler mhandler;
    //int currentpos, duration;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        play = (Button)findViewById(R.id.playbutton);
        previous = (Button)findViewById(R.id.previousbutton);
        next = (Button)findViewById(R.id.nextbutton);
        leftTime = (TextView)findViewById(R.id.leftTime);
        rightTime = (TextView)findViewById(R.id.rightTime);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.track2);

        /*currentpos = mediaPlayer.getCurrentPosition();
        duration = mediaPlayer.getDuration();*/
        final SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");

        /*For some reason, the time stamps start from 30:00. So every time stamp to be displayed has
        * to be subtracted with 1800000 miliseconds (equivalent to 30 minutes) to compensate for
        * the error*/
        leftTime.setText(dateFormat.format(new Date(mediaPlayer.getCurrentPosition()-1800000)));
        rightTime.setText(dateFormat.format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()-1800000)));

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaPlayer.seekTo(seekBar.getProgress());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                seekBar.setProgress(0);
                /*currentpos = 0;
                duration = mediaPlayer.getDuration();*/
                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                leftTime.setText(dateFormat.format(new Date(mediaPlayer.getCurrentPosition()-1800000)));
                rightTime.setText(dateFormat.format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()-1800000)));

                play.setBackgroundResource(android.R.drawable.ic_media_play);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    play.setBackgroundResource(android.R.drawable.ic_media_play);
                }
                else{
                    mediaPlayer.start();
                    play.setBackgroundResource(android.R.drawable.ic_media_pause);
                    updatethread();
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setProgress(0);
                mediaPlayer.seekTo(0);
                leftTime.setText(dateFormat.format(new Date(mediaPlayer.getCurrentPosition()-1800000)));
                rightTime.setText(dateFormat.format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()-1800000)));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setProgress(mediaPlayer.getDuration());
                mediaPlayer.seekTo(mediaPlayer.getDuration());
                leftTime.setText(dateFormat.format(new Date(mediaPlayer.getCurrentPosition()-1800000)));
                rightTime.setText(dateFormat.format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()-1800000)));
            }
        });
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
        thread.interrupt();
        thread = null;
        super.onDestroy();
    }

    public void updatethread(){
        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    while (mediaPlayer!= null && mediaPlayer.isPlaying()) {
                        Thread.sleep(50);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                                leftTime.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss")
                                .format(new Date(mediaPlayer.getCurrentPosition()))));

                                rightTime.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss")
                                        .format(new Date(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()))));
                            }
                        });
                    }
                }catch(InterruptedException e){e.printStackTrace();}
            }
        };
        thread.start();
    }
}
