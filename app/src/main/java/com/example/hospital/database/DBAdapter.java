package com.example.hospital.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.hospital.database.DBHelper.COLUMN_USER_BLOOD_TYPE;
import static com.example.hospital.database.DBHelper.COLUMN_USER_EMAIL;
import static com.example.hospital.database.DBHelper.COLUMN_USER_HEIGHT;
import static com.example.hospital.database.DBHelper.COLUMN_USER_PASSWORD;
import static com.example.hospital.database.DBHelper.COLUMN_USER_SITUATION;
import static com.example.hospital.database.DBHelper.COLUMN_USER_WEIGHT;

public class DBAdapter {
    SQLiteDatabase db;
    DBHelper myhelper;
    public DBAdapter(Context context){
        myhelper = new DBHelper(context);
        db = myhelper.getWritableDatabase();
    }

    public long insertData(String name,String email,String pass,String blood,String situation,String height,String weight){
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_USER_NAME, name);

        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_USER_PASSWORD, pass);
        values.put(COLUMN_USER_HEIGHT, height);
        values.put(COLUMN_USER_WEIGHT, weight);
        values.put(COLUMN_USER_SITUATION, situation);
        values.put(COLUMN_USER_BLOOD_TYPE, blood);
        long id = db.insert(DBHelper.TABLE_USER, null , values);

        db.close();
        return id;
    }

    public String getData()   {
        String[] columns = {
                COLUMN_USER_SITUATION,
                COLUMN_USER_BLOOD_TYPE,
                COLUMN_USER_HEIGHT,
                COLUMN_USER_WEIGHT,
                DBHelper.COLUMN_USER_NAME};
        Cursor cursor =db.query(DBHelper.TABLE_USER,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext()){
            String email =cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL));
            String name =cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_USER_NAME));
            String blood =cursor.getString(cursor.getColumnIndex(COLUMN_USER_BLOOD_TYPE));
            String height =cursor.getString(cursor.getColumnIndex(COLUMN_USER_HEIGHT));
            String weight =cursor.getString(cursor.getColumnIndex(COLUMN_USER_WEIGHT));
            String situation =cursor.getString(cursor.getColumnIndex(COLUMN_USER_SITUATION));


            buffer.append(email+ "   " + name +" \n\n"+blood+ "   " + height +" \n\n"+weight+ "   " +situation +" \n\n");
        }
        return buffer.toString();
    }
}
