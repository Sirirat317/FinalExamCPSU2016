package com.example.user.finalexamcpsu2016;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static com.example.user.finalexamcpsu2016.DataBaseHelper.TABLE_NAME;

/**
 * Created by User on 18/12/2559.
 */

public class LoginAdapter {

    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;


    public SQLiteDatabase db;

    private final Context context;

    private DataBaseHelper dbHelper;
    public  LoginAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  LoginAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String Name , String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        newValues.put("NAME",Name);
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);


        db.insert(TABLE_NAME, null, newValues);
    }
    public int deleteEntry(String UserName)
    {

        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;

        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void  updateEntry(String Name , String userName,String password)
    {

        ContentValues updatedValues = new ContentValues();

        updatedValues.put("NAME", Name);
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});
    }
}
