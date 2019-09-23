package com.example.honey_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText listText;
    private Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listText = (EditText)findViewById(R.id.listText);
        saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writetofile(listText.getText().toString());
            }
        });

        try {
            if (readfromfile() != null){
                listText.setText(readfromfile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writetofile(String message){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("toDoList.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
            outputStreamWriter.close(); //Always close your streams.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String readfromfile() throws IOException{
        String result = "";
        try {
            InputStream inputStream = openFileInput("toDoList.txt");
            if (inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String tempString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((tempString = bufferedReader.readLine()) != null){
                    stringBuilder.append(tempString);
                }
                inputStream.close();
                result = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
