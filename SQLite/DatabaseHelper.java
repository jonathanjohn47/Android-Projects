package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "studentTable";

    /*Defining the four columns of the table*/
    public static final String Col_1 = "ID";
    public static final String Col_2 = "First_Name";
    public static final String Col_3= "Last_Name";
    public static final String Col_4 = "Marks";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        /*Whenever this constructor is called, our databse is created*/

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +" ("
                + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + Col_2 + " TEXT, "
                + Col_3 + " TEXT, "
                + Col_4 + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, int marks){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Col_2, name);
            contentValues.put(Col_3, surname);
            contentValues.put(Col_4, marks);

            long result = db.insert(TABLE_NAME, null, contentValues);

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }catch (Exception e){
            Log.e("Error: ", String.valueOf(e));
            return false;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(int id, String firstname, String surname, int marks){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues res = new ContentValues();
            res.put(Col_1, id);
            res.put(Col_2, firstname);
            res.put(Col_3, surname);
            res.put(Col_4, marks);
            db.update(TABLE_NAME, res, Col_1 + " = ?", new String[]{String.valueOf(id)});
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public Integer deleteData(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues res = new ContentValues();
        return db.delete(TABLE_NAME, Col_1 + " = ?", new String[]{String.valueOf(id)});
    }

    public Cursor readText(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + Col_2 + " FROM " + TABLE_NAME + " WHERE " + Col_1 + " = ?", new String[]{String.valueOf(id)});
        return cursor;
    }
}
