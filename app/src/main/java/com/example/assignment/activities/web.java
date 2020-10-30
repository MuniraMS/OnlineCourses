package com.example.assignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.assignment.R;

public class web extends AppCompatActivity implements View.OnClickListener {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick (View v){
        Intent intent = new Intent (this, coursesinfo.class );
        startActivity(intent);
    }

}
