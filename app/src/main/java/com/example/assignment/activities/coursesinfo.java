package com.example.assignment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.assignment.R;

public class coursesinfo extends AppCompatActivity implements View.OnClickListener {
    RadioButton Graphic,web,digitaldesign;
    Button view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursesinfo);
        Graphic = (RadioButton) findViewById(R.id.graphic);
        web = (RadioButton) findViewById(R.id.web);
        digitaldesign = (RadioButton) findViewById(R.id.digitaldesign);
        view = (Button) findViewById(R.id.view);
        view.setOnClickListener(this);
    }
    @Override
    public void onClick (View v) {
        if (Graphic.isChecked()) {
            Intent intent = new Intent (this, graphic.class );
            startActivity(intent);
        }
        else
            if (web.isChecked()){
                Intent intent = new Intent (this, web.class );
                startActivity(intent);
            }
            else
                if (digitaldesign.isChecked()){
                    Intent intent = new Intent (this, logicaldesign.class );
                    startActivity(intent);
                }
                else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                    builder1.setMessage("You have to choose course.");
                    builder1.setTitle("Warning");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
    }
}
