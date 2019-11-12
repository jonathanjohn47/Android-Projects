package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mCityListView;
    /*
    String [] mCitiesString = {
            "Delhi1", "Mumbai1", "Chennai1", "Kolkata1",
            "Delhi2", "Mumbai2", "Chennai2", "Kolkata2",
            "Delhi3", "Mumbai3", "Chennai3", "Kolkata3",
            "Delhi4", "Mumbai4", "Chennai4", "Kolkata4",
            "Delhi5", "Mumbai5", "Chennai5", "Kolkata5",
            "Delhi6", "Mumbai6", "Chennai6", "Kolkata6",};

     */
    private ArrayList<String> mCities;
    private ArrayAdapter<String> mAdapterCities;

    private EditText mEnterCityName;
    private Button mBtnAddCity, mBtnRemoveCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterCityName = findViewById(R.id.enterCityName);
        mBtnAddCity = findViewById(R.id.btnAddCity);
        mBtnRemoveCity = findViewById(R.id.btnRemoveCity);

        mCities = new ArrayList<String>();
        mCityListView = findViewById(R.id.cityListViews);

        //Creating Adapter
        mAdapterCities = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mCities);
        mCityListView.setAdapter(mAdapterCities);

        mBtnAddCity.setOnClickListener(new AddRemoveCityListener());
        mBtnRemoveCity.setOnClickListener(new AddRemoveCityListener());

        mCityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class AddRemoveCityListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == mBtnAddCity){
                mCities.add(mEnterCityName.getText().toString());
                mAdapterCities.notifyDataSetChanged();
            }
            if (v == mBtnRemoveCity){
                mCities.remove(mEnterCityName.getText().toString());
                mAdapterCities.notifyDataSetChanged();
            }
        }
    }
}
