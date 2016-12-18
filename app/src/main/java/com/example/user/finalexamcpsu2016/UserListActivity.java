package com.example.user.finalexamcpsu2016;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    private DataBaseHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<Contact> mContactList = new ArrayList<>();
    private ListView mContactListView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);


        mDb = mHelper.getWritableDatabase();
        mContactListView = (ListView) findViewById(R.id.contact_list_view);


    }
}
