package in.bitcode.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerCities;
    private ArrayList<City> mListCities;
    private AdapterCities mAdapterCites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerCities = findViewById(R.id.recyclerCities);
        mListCities = new ArrayList<City>();

        init();

        mAdapterCites = new AdapterCities(mListCities);
        mRecyclerCities.setAdapter(mAdapterCites);

       /* LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false
                );
        mRecyclerCities.setLayoutManager(linearLayoutManager);
        */

        GridLayoutManager gridLayoutManager =
                new GridLayoutManager( this, 2 );
        mRecyclerCities.setLayoutManager( gridLayoutManager );

        mAdapterCites.setOnCityClickListener(new MyOnCityClickListener());

    }

    private void init() {
        mListCities.add(new City("Sinnar1", R.drawable.img1));
        mListCities.add(new City("Sinnar2", R.drawable.img2));
        mListCities.add(new City("Sinnar3", R.drawable.img3));
        mListCities.add(new City("Sinnar4", R.drawable.img4));
        mListCities.add(new City("Sinnar5", R.drawable.img5));
        mListCities.add(new City("Sinnar6", R.drawable.img6));
        mListCities.add(new City("Sinnar7", R.drawable.img7));
        mListCities.add(new City("Sinnar8", R.drawable.img8));
        mListCities.add(new City("Sinnar9", R.drawable.img9));
    }

    private class MyOnCityClickListener implements AdapterCities.OnCityClickListener {
        @Override
        public void onCityClick(City city, int position) {

            Toast.makeText( MainActivity.this, city.getName(), Toast.LENGTH_LONG).show();

        }
    }
}
