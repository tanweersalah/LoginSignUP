package com.example.lenovo.LoginSignUp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Data.DataBase;

public class SignUp extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    EditText name;
    EditText email;
    EditText passw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        openHelper = new DataBase(this);
         name = (EditText)findViewById(R.id.editText);
         passw = (EditText)findViewById(R.id.editText2);
         email = (EditText)findViewById(R.id.editText3);
        Button Sign_up = (Button) findViewById(R.id.SignUpbtn);
        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = openHelper.getWritableDatabase();
                String nam = name.getText().toString();
                String em = email.getText().toString();
                String pass= passw.getText().toString();
                addData(nam,pass,em);
                Toast.makeText(getApplicationContext(), "successfully signed up", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
                finish();



            }
        });


    }

    private void addData(String name, String password, String email){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBase.COLM_1,name);
        contentValues.put(DataBase.COLM_2,password);
        contentValues.put(DataBase.COLM_3,email);
        long id = sqLiteDatabase.insert(DataBase.TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();









    }



}
