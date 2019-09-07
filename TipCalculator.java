package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tipPercentage, total;
    private Button calculate, clearAll;
    private EditText bill;
    private SeekBar seekBar;
    private CheckBox gst, vat, servicecharges;
    private Switch rsdollars;

    private Double GST= Double.valueOf(0);
    private Double VAT=Double.valueOf(0);
    private Double serviceCharges=Double.valueOf(0);
    private Double BILL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipPercentage = (TextView)findViewById(R.id.tipPercentage);
        total = (TextView)findViewById(R.id.total);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        bill = (EditText)findViewById(R.id.bill);
        calculate = (Button)findViewById(R.id.calculateTip);
        clearAll = (Button)findViewById(R.id.allClear);
        gst = (CheckBox)findViewById(R.id.GST);
        vat = (CheckBox)findViewById(R.id.VAT);
        servicecharges = (CheckBox)findViewById(R.id.serviceCharge);
        rsdollars = (Switch)findViewById(R.id.rsdollars);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercentage.setText(seekBar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //tipPercentage.setText(seekBar.getProgress() + "%");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                tipPercentage.setText(seekBar.getProgress() + "%");

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String str = bill.getText().toString();
                    Double d = new Double(str);
                    BILL = d;
                    Double e = new Double(seekBar.getProgress());

                    if (gst.isChecked()){
                        GST = d*18/100;
                    }
                    else{
                        GST = 0.0;
                    }

                    if (vat.isChecked()){
                        VAT = d*5/100;
                    }
                    else{
                        VAT = 0.0;
                    }
                    if (servicecharges.isChecked()){
                        serviceCharges = d*5/100;
                    }
                    else{
                        serviceCharges = 0.0;
                    }

                    if (rsdollars.isChecked() == false) {
                        Double Total = d + (e / 100 * d) + GST + VAT + serviceCharges;
                        total.setText("$" + Total.toString());
                    }
                    else{
                        Double Total = d + (e / 100 * d) + GST + VAT + serviceCharges;
                        Total = Total*71.2;
                        total.setText("Rs." + Total.toString());
                    }
                }
                catch (NumberFormatException e){}
            }
        });

        clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bill.setText(null);
                seekBar.setProgress(0);
                tipPercentage.setText(null);
                total.setText(null);

                GST = Double.valueOf(0);
                VAT = Double.valueOf(0);
                serviceCharges = Double.valueOf(0);

                gst.setChecked(false);
                vat.setChecked(false);
                servicecharges.setChecked(false);

                rsdollars.setChecked(false);
            }
        });
    }
}
