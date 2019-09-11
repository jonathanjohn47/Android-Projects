package com.example.petbio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView catview, dogview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catview = (ImageView)findViewById(R.id.catview);
        dogview = (ImageView)findViewById(R.id.dogview);

        catview.setOnClickListener(this);
        dogview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.catview:
                //Toast.makeText(this, "Cat is clicked", Toast.LENGTH_SHORT).show();
                Intent catIntent = new Intent(MainActivity.this, BioActivity.class);
                catIntent.putExtra("Name", "Jarvis");
                catIntent.putExtra("Bio", "Great Cat, loves people. Meows a lot!");
                startActivity(catIntent);
                break;
            case R.id.dogview:
                //Toast.makeText(this, "Dog is clicked", Toast.LENGTH_SHORT).show();
                Intent dogIntent = new Intent(MainActivity.this, BioActivity.class);
                dogIntent.putExtra("Name", "Dufus");
                dogIntent.putExtra("Bio", "Great Dog. Loves people. Barks and eats a lot.");
                startActivity(dogIntent);
                break;
        }
    }
}
