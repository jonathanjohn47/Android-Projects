package com.example.petbio;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BioActivity extends AppCompatActivity {

    private TextView  petname, petbio;
    private ImageView petimageview;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        petname = (TextView)findViewById(R.id.petName);
        petbio = (TextView)findViewById(R.id.petBio);
        petimageview = (ImageView)findViewById(R.id.petImageView);
        extras = getIntent().getExtras();
        if (extras != null){
            String name = extras.getString("Name");
            String bio = extras.getString("Bio");
            setup(name, bio);
        }

    }

    public void setup(String name, String bio){
        try {
            if (name.equals("Dufus")) {
                //We show Dog Stuff
                petimageview.setImageDrawable(getResources().getDrawable(R.drawable.dog));
                petname.setText(name);
                petbio.setText(bio);
            } else if (name.equals("Jarvis")) {
                //We show cat stuff
                petimageview.setImageDrawable(getResources().getDrawable(R.drawable.cat));
                petname.setText(name);
                petbio.setText(bio);
            } else {
                Toast.makeText(this, "Nothing to show", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Log.e("Error", e.toString());}
    }
}
