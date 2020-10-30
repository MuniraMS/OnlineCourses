package com.example.assignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.assignment.R;
import com.example.assignment.database.DatabaseHelper;
import com.example.assignment.Adapter.studentadapter;
import com.example.assignment.model.student;
import java.util.ArrayList;
public class studentsinformation extends AppCompatActivity {
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentsinformation);
         dbhelper = DatabaseHelper.getInstance(this);
        final ArrayList<student> students  = dbhelper.getStudents();
        ListView listview = findViewById(R.id.lstview);
        ArrayAdapter<student> adapter = new studentadapter (this, students);
        listview.setAdapter(adapter);



    }
}
