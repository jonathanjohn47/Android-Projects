package in.bitcode.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerCities;

    private ArrayList<City> mListCities;
    private ArrayList<String> mListStates;

    private AdapterCities mAdapterCites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerCities = findViewById(R.id.recyclerCities);

        mListCities = new ArrayList<City>();
        mListStates = new ArrayList<String>();

        init();

        mAdapterCites = new AdapterCities(mListCities, mListStates);
        mRecyclerCities.setAdapter(mAdapterCites);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false
                );
        mRecyclerCities.setLayoutManager(linearLayoutManager);

        mAdapterCites.setOnCityClickListener(
                new MyOnCityClickListener()
        );
        mAdapterCites.setOnStateClickListener(
                new MyOnStateClickListener()
        );

    }

    private void init() {
        mListCities.add(new City("Pune1", R.drawable.img1));
        mListCities.add(new City("Pune2", R.drawable.img2));
        mListCities.add(new City("Pune3", R.drawable.img3));
        mListCities.add(new City("Pune4", R.drawable.img4));
        mListCities.add(new City("Pune5", R.drawable.img5));
        mListCities.add(new City("Pune6", R.drawable.img6));
        mListCities.add(new City("Pune7", R.drawable.img7));
        mListCities.add(new City("Pune8", R.drawable.img8));
        mListCities.add(new City("Pune9", R.drawable.img9));

        mListStates.add("Maharashtra");
        mListStates.add("Karnataka");
        mListStates.add("Jammu");

    }

    private class MyOnCityClickListener implements AdapterCities.OnCityClickListener {
        @Override
        public void onCityClick(int position, City city) {

            Snackbar.make(
                    mRecyclerCities,
                    city.getName() + " " + position,
                    Snackbar.LENGTH_LONG

            ).setActionTextColor(Color.WHITE)
                    .setAction(
                            "Okay",
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            }
                            )
                    .show();
        }
    }

    private class MyOnStateClickListener implements AdapterCities.OnStateClickListener {
        @Override
        public void onStateClick(int position, String state) {
            Snackbar.make(
                    mRecyclerCities,
                    state + " " + position,
                    Snackbar.LENGTH_LONG

            ).show();
        }
    }


}
