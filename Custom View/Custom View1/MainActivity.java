package in.bitcode.customview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox mChkExit;
    private ExitButton mBtnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChkExit = findViewById( R.id.chkExit );
        mBtnExit = findViewById( R.id.btnExit );

        mChkExit.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked ) {

                        mBtnExit.setExitable( isChecked );

                    }
                }
        );
    }
}
