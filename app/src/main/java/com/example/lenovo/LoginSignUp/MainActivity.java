package com.example.lenovo.LoginSignUp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.database.Welcom;

import Data.DataBase;

public class MainActivity extends AppCompatActivity {
    EditText email, pass ;
    TextView signup , login;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    String email1="";
    String pass1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email= (EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        openHelper= new DataBase(this);
        sqLiteDatabase= openHelper.getReadableDatabase();

        signup = (TextView) findViewById(R.id.textView);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);




            }
        });
        login =(Button) findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email1 = email.getText().toString().toLowerCase().trim();
                 pass1 = pass.getText().toString();

                 if (email1.equals("")&&pass1.equals("")){

                     Toast.makeText(getApplicationContext(),"Please enter user id & password ", Toast.LENGTH_LONG).show();

                 }

                 else{
                cursor = sqLiteDatabase.rawQuery("SELECT *FROM " + DataBase.TABLE_NAME + " WHERE " + DataBase.COLM_3 + "=? AND " + DataBase.COLM_2 + "=?", new String[]{email1, pass1});
                if (cursor!= null){
                    if (cursor.getCount()>0)
                    {Toast.makeText(getApplicationContext(),"login successfull", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(MainActivity.this, Welcom.class);
                    startActivity(intent);
                    finish();
                        }
                    else {
                        Toast.makeText(getApplicationContext(),"incorrect id password", Toast.LENGTH_LONG).show();
                }



                }}





            }
        });




    }
}
