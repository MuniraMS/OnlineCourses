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
public class Signupstudent extends AppCompatActivity implements View.OnClickListener {
    EditText nameEdit,IDedit,levelEdit,UsernameEdit,PasswordEdit;
    DatabaseHelper dbhelper;
    Button previous,signup;
    String name,username,password;
    int level,ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupstudent);
        dbhelper = DatabaseHelper.getInstance(this);
        nameEdit = (EditText) findViewById(R.id.name);
        IDedit = (EditText) findViewById(R.id.ID);
        levelEdit = (EditText) findViewById(R.id.level);
        UsernameEdit = (EditText) findViewById(R.id.username);
        PasswordEdit = (EditText) findViewById(R.id.password);
        previous = (Button) findViewById(R.id.previous2);
        signup = (Button) findViewById(R.id.Signupstu);
        previous.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.previous2){
            Intent intent = new Intent (this,student.class);
            startActivity(intent);
        }
        else
            if(v.getId()==R.id.Signupstu){
                name = nameEdit.getText().toString();
                username = UsernameEdit.getText().toString();
                password = PasswordEdit.getText().toString();
                level = Integer.valueOf(levelEdit.getText().toString());
                ID = Integer.valueOf(IDedit.getText().toString());
                dbhelper.signupStudent(name,ID,level,username,password);
                Toast.makeText(this,"Data inserted,please login.",Toast.LENGTH_LONG).show();
                Intent intent = new Intent (this,student.class);
                startActivity(intent);
            }


    }
}
