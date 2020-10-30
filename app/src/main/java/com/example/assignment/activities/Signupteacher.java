package com.example.assignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.assignment.R;
import com.example.assignment.database.DatabaseHelper;

public class Signupteacher extends AppCompatActivity implements View.OnClickListener {
    EditText usernameedit,passwordedit;
    DatabaseHelper dbhelper;
    Button previous,signup;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupteacher);
        dbhelper = DatabaseHelper.getInstance(this);
        usernameedit = (EditText) findViewById(R.id.username);
        passwordedit = (EditText) findViewById(R.id.password);
        previous = (Button) findViewById(R.id.previous3);
        signup = (Button) findViewById(R.id.signup);
        previous.setOnClickListener(this);
        signup.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v.getId()==R.id.previous3){
            Intent intent = new Intent (this, teacher.class);
            startActivity(intent);
        }
        else
            if (v.getId()==R.id.signup){
                username = usernameedit.getText().toString();
                password = passwordedit.getText().toString();
                dbhelper.signupTeacher(username,password);
                Toast.makeText(this,"Data inserted,please login.",Toast.LENGTH_LONG).show();
                Intent intent = new Intent (this, teacher.class);
                startActivity(intent);

            }
    }
}
