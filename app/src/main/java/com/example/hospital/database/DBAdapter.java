package com.example.hospital.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.example.hospital.database.DBHelper.COLUMN_USER_BLOOD_TYPE;
import static com.example.hospital.database.DBHelper.COLUMN_USER_EMAIL;
import static com.example.hospital.database.DBHelper.COLUMN_USER_HEIGHT;
import static com.example.hospital.database.DBHelper.COLUMN_USER_NAME;
import static com.example.hospital.database.DBHelper.COLUMN_USER_PASSWORD;
import static com.example.hospital.database.DBHelper.COLUMN_USER_SITUATION;
import static com.example.hospital.database.DBHelper.COLUMN_USER_WEIGHT;
import static com.example.hospital.database.DBHelper.TABLE_USER;

public class DBAdapter {
    SQLiteDatabase db;
    DBHelper myhelper;

    public DBAdapter(Context context) {
        myhelper = new DBHelper(context);
        db = myhelper.getWritableDatabase();

    }

    public void insertData(String name, String email, String pass, String blood, String situation, String height, String weight) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, name);

        values.put(COLUMN_USER_EMAIL, email);
        values.put(COLUMN_USER_PASSWORD, pass);
        values.put(COLUMN_USER_HEIGHT, height);
        values.put(COLUMN_USER_WEIGHT, weight);
        values.put(COLUMN_USER_SITUATION, situation);
        values.put(COLUMN_USER_BLOOD_TYPE, blood);
        //long id =
        db.insert(DBHelper.TABLE_USER, null, values);

        db.close();
        //    return id;
    }

    public void updateData(String email, String name, String pass, String blood, String situation, String height, String weight) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, name);

        values.put(COLUMN_USER_PASSWORD, pass);
        values.put(COLUMN_USER_HEIGHT, height);
        values.put(COLUMN_USER_WEIGHT, weight);
        values.put(COLUMN_USER_SITUATION, situation);
        values.put(COLUMN_USER_BLOOD_TYPE, blood);

        String[] arrayOfWhere = {email};
        db.update(TABLE_USER, values, COLUMN_USER_EMAIL + " = ?", arrayOfWhere);
        db.close();
    }

    public String[] getData(String mail) {

        db = myhelper.getReadableDatabase();
        String[] columns = {
                COLUMN_USER_SITUATION,
                COLUMN_USER_BLOOD_TYPE,
                COLUMN_USER_HEIGHT,
                COLUMN_USER_WEIGHT,
                COLUMN_USER_EMAIL,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_NAME};
        String selection = COLUMN_USER_EMAIL + " = ?";

        String[] selectionArgs = {mail};
        Cursor cursor = db.query(DBHelper.TABLE_USER, columns, selection, selectionArgs, null, null, null);
        String[] buffer = new String[columns.length];
        while (cursor.moveToNext()) {
            String email = cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));
            String blood = cursor.getString(cursor.getColumnIndex(COLUMN_USER_BLOOD_TYPE));
            String height = cursor.getString(cursor.getColumnIndex(COLUMN_USER_HEIGHT));
            String weight = cursor.getString(cursor.getColumnIndex(COLUMN_USER_WEIGHT));
            String situation = cursor.getString(cursor.getColumnIndex(COLUMN_USER_SITUATION));
            String password = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD));
            buffer[0] = email;
            buffer[1] = name;
            buffer[2] = blood;
            buffer[3] = height;
            buffer[4] = weight;
            buffer[5] = situation;
            buffer[6] = password;
        }
        cursor.close();
        return buffer;
    }
}
