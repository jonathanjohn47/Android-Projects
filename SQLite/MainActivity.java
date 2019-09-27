package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;

    EditText name, surname, marks, id;
    Button addData, getData, updateData, deleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);

        name = (EditText)findViewById(R.id.editText_name);
        surname = (EditText)findViewById(R.id.editText_surname);
        marks = (EditText)findViewById(R.id.editText_Marks);
        id = (EditText)findViewById(R.id.editText_id);

        addData = (Button)findViewById(R.id.button_add);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentname = name.getText().toString();
                String studentsurname = surname.getText().toString();
                String studentmarks = marks.getText().toString();
                int marks = Integer.parseInt(studentmarks);
                boolean isInserted = mydb.insertData(studentname, studentsurname, marks);
                if (isInserted==true){
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        getData = (Button)findViewById(R.id.button_viewAll);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = mydb.getAllData();
                if (result.getCount()==0){
                    showMessage("Error!", "Nothing Found");
                }
                else{
                    StringBuffer buffer = new StringBuffer();
                    while(result.moveToNext()){
                        buffer.append(result.getString(0) + "\t");
                        buffer.append(result.getString(1) + "\t");
                        buffer.append(result.getString(2) + "\t");
                        buffer.append(result.getString(3) + "\n");
                    }
                    showMessage("Data", buffer.toString());
                }
            }
        });

        updateData = (Button)findViewById(R.id.button_update);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ID = Integer.parseInt(id.getText().toString());
                String studentname = name.getText().toString();
                String studentsurname = surname.getText().toString();
                String studentmarks = marks.getText().toString();
                int marks = Integer.parseInt(studentmarks);

                boolean isUpdated = mydb.updateData(ID, studentname, studentsurname, marks);
                if (isUpdated == true){
                    showMessage("Data Updated!", "Data successfully upadated.");
                }
                else{
                    showMessage("Error!", "Data not updated.");
                }
            }
        });

        deleteData = (Button)findViewById(R.id.button_delete);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletedData = mydb.deleteData(Integer.parseInt(id.getText().toString()));
                if (deletedData == 0){
                    showMessage("Error", "No data deleted");
                }
                else {
                    showMessage("Deleted", "Successfully deleted " + deletedData + " data row.");
                    /*Now update all the id numbers for rest of the data that follows the deleted row*/

                }
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
}
