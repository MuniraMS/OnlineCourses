package com.example.assignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.assignment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.student);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                gotostudent();
            }

        });
        Button button2 = (Button) findViewById(R.id.teacher);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                gototeacher();
            }

        });
    }
    private void gotostudent(){
        Intent intent = new Intent (this, student.class);
        startActivity(intent);
    }
    private void gototeacher(){
        Intent intent = new Intent (this, teacher.class);
        startActivity(intent);
    }
}
