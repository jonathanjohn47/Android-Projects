package in.bitcode.customview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListViewTasks;
    private ArrayList<Task> mListTasks;
    private AdapterTasks mAdapterTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        mListViewTasks = findViewById( R.id.listViewTasks );
        mListTasks = new ArrayList<Task>();
        mAdapterTasks = new AdapterTasks( this, mListTasks );
        mListViewTasks.setAdapter( mAdapterTasks );

        mListTasks.add( new Task( 101, "Pay Bills", true ) );
        mListTasks.add( new Task( 101, "Email office", false ) );
        mListTasks.add( new Task( 101, "Buy stuff", false ) );
        mListTasks.add( new Task( 101, "Visit places", true ) );

    }
}
