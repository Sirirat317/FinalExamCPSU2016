package com.example.user.finalexamcpsu2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    LoginAdapter loginAdapter;

    Button button_Re,button_Log;
    EditText editTextLogUser , editTextLogPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginAdapter = new LoginAdapter(this);
        loginAdapter = loginAdapter.open();

        button_Re = (Button) findViewById(R.id.button_re);
        button_Re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_Re = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent_Re);
            }
        });


        editTextLogUser = (EditText)findViewById(R.id.editTextLogUser);
        editTextLogPass = (EditText)findViewById(R.id.editTextLoginPass);

        button_Log = (Button)findViewById(R.id.button_login);
        button_Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String _Username = editTextLogUser.getText().toString();
                String _Password = editTextLogPass.getText().toString();

                String _Stored = loginAdapter.getSinlgeEntry(_Username);

               if(_Username.equals("") || _Password.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Imalid uername or password.", Toast.LENGTH_LONG).show();
                }
                else
                {

                    Intent intent_login = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent_login);
                }
            }


        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_show_list) {
            Intent intent = new Intent(this, UserListActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
