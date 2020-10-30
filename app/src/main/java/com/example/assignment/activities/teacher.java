package com.example.assignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.assignment.R;
import com.example.assignment.database.DatabaseHelper;

public class teacher extends AppCompatActivity implements View.OnClickListener {
    EditText usernameEdit,passwordEdit;
     DatabaseHelper dbhelper;
     Button previousbtn,loginbtn;
     String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        dbhelper = DatabaseHelper.getInstance(this);
        usernameEdit = (EditText) findViewById(R.id.username);
        passwordEdit = (EditText) findViewById(R.id.password);
        previousbtn = (Button) findViewById(R.id.previous);
        loginbtn = (Button) findViewById(R.id.login);
        previousbtn.setOnClickListener(this);
        loginbtn.setOnClickListener(this);
    }
    @Override
    public void onClick (View v){
       if(v.getId()==R.id.previous){
           Intent intent = new Intent (this,MainActivity.class);
           startActivity(intent);
       }
       else
           if (v.getId()==R.id.login){
               username = usernameEdit.getText().toString();
               password = passwordEdit.getText().toString();
               boolean islogged = dbhelper.loginTeacher(username,password);
               if (islogged){
                   Toast.makeText(this,"logged in successfully.",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent (this,studentsinformation.class);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(this,"You have to sign up.",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent (this,Signupteacher.class);
                   startActivity(intent);
               }
           }


    }
}
