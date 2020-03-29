package com.example.hospital.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "UserManager.db";

    // User table name
    public static final String TABLE_USER = "user";

    // User Table Columns names
    public static final String COLUMN_USER_ID = "user_id";

    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_EMAIL = "user_email";
    public static final String COLUMN_USER_PASSWORD = "user_password";
    public static final String COLUMN_USER_BLOOD_TYPE = "user_blood";
    public static final String COLUMN_USER_SITUATION = "user_situation";
    public static final String COLUMN_USER_HEIGHT = "user_height";
    public static final String COLUMN_USER_WEIGHT = "user_weight";



    // create table sql query
    public String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_SITUATION + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_BLOOD_TYPE + " TEXT,"
            + COLUMN_USER_HEIGHT + " TEXT," + COLUMN_USER_WEIGHT + " TEXT"
            + ")";

    // drop table sql query
    public String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DBHelper(Context context){
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        } catch (Exception e) {
            e.printStackTrace();


        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try{
            sqLiteDatabase.execSQL(DROP_USER_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
