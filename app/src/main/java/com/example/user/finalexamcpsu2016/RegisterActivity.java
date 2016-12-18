package com.example.user.finalexamcpsu2016;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextRename, editTextReUser,editTextRePass;
    Button button_create;

    LoginAdapter loginAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginAdapter=new LoginAdapter(this);
        loginAdapter = loginAdapter.open();

        editTextRename = (EditText)findViewById(R.id.editTextReName);
        editTextReUser = (EditText)findViewById(R.id.editTextReUser);
        editTextRePass = (EditText)findViewById(R.id.editTextRePass);

        button_create = (Button)findViewById(R.id.button_create);
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _editName = editTextRename.getText().toString();
                String _editUsername = editTextReUser.getText().toString();
                String _editPass = editTextRePass.getText().toString();



                String _Stored = loginAdapter.getSinlgeEntry(_editUsername);

                if (_editName.equals("") || _editUsername.equals("") || _editPass.equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("Registartion faliled");
                    builder.setMessage("Username already exists");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                } else {
                    loginAdapter.insertEntry(_editName,_editUsername,_editPass);
                    Toast.makeText(getApplicationContext(), "Created Account Successfully  ", Toast.LENGTH_LONG).show();
                }




            }
        });




    }
}
