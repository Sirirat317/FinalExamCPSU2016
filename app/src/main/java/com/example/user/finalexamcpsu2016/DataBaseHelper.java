package com.example.user.finalexamcpsu2016;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by User on 18/12/2559.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Login";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Login";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    private static final String SQL_CRATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_USERNAME + " TEXT"
                    + COL_PASSWORD + " TEXT"
                    + ")";


    public DataBaseHelper(Context context, String databaseName, Object o, int databaseVersion) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CRATE_TABLE);

        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "aaa");
        cv.put(COL_NAME, "bbb");
        cv.put(COL_PASSWORD, "ccc");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        Log.w("TaskDBAdapter", "Upgrading from version "
                +_oldVersion + " to "
                +_newVersion + ", which will destroy all old data");
        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");

        onCreate(_db);
    }



}
