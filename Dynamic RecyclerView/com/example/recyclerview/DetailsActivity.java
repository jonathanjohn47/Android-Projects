package com.example.recyclerview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    private TextView name, description;
    private Bundle extras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras = getIntent().getExtras();
        name = (TextView)findViewById(R.id.namedisplay);
        description = (TextView)findViewById(R.id.descriptiondisplay);

        if (extras != null){
            name.setText(extras.getString("Name"));
            description.setText(extras.getString("Description"));
        }
    }
}
