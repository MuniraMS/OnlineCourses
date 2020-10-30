package com.example.assignment.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.example.assignment.model.student;
import com.example.assignment.model.teacher;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper sInstance;
    Context context;
    //database ver and name
    private static final String DATABASE_NAME = "Courses";
    private static final int DATABASE_VERSION = 3;
    //Table names
    private static final String TABLE_ONE = "teacher";
    private static final String TABLE_TWO = "student";
    //Table one columns
    private static final String KEY_username = "username";
    private static final String KEY_password = "password";
    //Table two columns
    private static final String KEY_name = "name";
    private static final String KEY_ID = "ID";
    private static final String KEY_level = "level";
    private static final String KEY_StuUsername = "username";
    private static final String KEY_stupassword = "password";

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_Table1 = "CREATE TABLE IF NOT EXISTS " + TABLE_ONE +
                "( " + KEY_username + " TEXT PRIMARY KEY, "
                + KEY_password + " TEXT " + " );";
        db.execSQL(Create_Table1);

        String Create_Table2 = "CREATE TABLE IF NOT EXISTS " + TABLE_TWO +
                "( " + KEY_name + " TEXT, "
                + KEY_ID + " INTEGER UNIQUE, "
                + KEY_level + " INTEGER, "
                + KEY_StuUsername + " TEXT PRIMARY KEY, "
                + KEY_stupassword + " TEXT " + " );";
        db.execSQL(Create_Table2);


        final teacher[] teachers = {
                new teacher("Sara", "123"),
                new teacher("nora", "1234"),
        };
        for (teacher t : teachers) {
            String insert = String.format("INSERT INTO %s (%s,%s) VALUES ('%s','%s');",
                    TABLE_ONE, KEY_username, KEY_password, t.getUsername(), t.getPassword());
            db.execSQL(insert);

        }
        final student[] students = {
                new student("munira", 437003868, 7, "imunira", "123"),
                new student("Sama", 437005009, 8, "isama", "123"),
                new student("Rasha", 437004422, 8, "irasha", "123"),
                new student("Raghad", 43720049, 8, "iraghad", "123"),
        };
        for (student s : students) {
            String insert = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES ('%s', %d, %d, '%s', '%s');",
                    TABLE_TWO, KEY_name, KEY_ID, KEY_level, KEY_StuUsername, KEY_stupassword, s.getName(), s.getID(), s.getLevel(), s.getUsername(), s.getPassword());
            db.execSQL(insert);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ONE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TWO);
            onCreate(db);
        }
    }

    public void signupTeacher(String username, String password) {
        String INSERT_QUERY = String.format("INSERT INTO %s (%s,%s) VALUES ('%s','%s');",
                TABLE_ONE, KEY_username, KEY_password, username, password);
        SQLiteDatabase db = getReadableDatabase();
        try {
            db.execSQL(INSERT_QUERY);

        } catch (Exception e) {
            System.out.println("epurr epurr");
            Toast.makeText(context, "error while signing up", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean loginTeacher(String username, String password) {
        String SELECT_QUERY = String.format("SELECT * FROM %s where %s = '%s' and %s= '%s'",
                TABLE_ONE, KEY_username, username, KEY_password, password);
        System.out.println(SELECT_QUERY);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                return true;
            } else
                return false;


        } catch (Exception e) {
            System.out.println("epurr epurr");
            Toast.makeText(context, "error while logging in", Toast.LENGTH_SHORT).show();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return false;
    }

    public void signupStudent(String name, int ID, int level, String username, String password) {
        String INSERT_QUERY = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES ('%s',%d,%d,'%s','%s');",
                TABLE_TWO, KEY_name, KEY_ID, KEY_level, KEY_StuUsername, KEY_stupassword, name, ID, level, username, password);
        SQLiteDatabase db = getReadableDatabase();
        try {
            db.execSQL(INSERT_QUERY);

        } catch (Exception e) {
            System.out.println("epurr epurr");
            Toast.makeText(context, "error while signing up", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean loginstudent(String StuUsername, String stupassword) {
        String SELECT_QUERY = String.format("SELECT * FROM %s where %s = '%s' and %s= '%s'",
                TABLE_TWO, KEY_StuUsername, StuUsername, KEY_stupassword, stupassword);
        System.out.println(SELECT_QUERY);
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery(SELECT_QUERY, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    System.out.println("DEBUG " + cursor.getString(cursor.getColumnIndex(KEY_StuUsername)));
                    cursor.close();
                    return true;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Exception e) {
                System.out.println("epurr epurr");
                Toast.makeText(context, "error while logging in", Toast.LENGTH_SHORT).show();
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<student> getStudents() {
        ArrayList<student> students = new ArrayList<>();
        String select_query = String.format("SELECT %s,%s,%s FROM %s",
                KEY_name, KEY_ID, KEY_level, TABLE_TWO);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(select_query, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    student s = new student ();
                    s.setName(cursor.getString(cursor.getColumnIndex(KEY_name)));
                    s.setID(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                    s.setLevel(cursor.getInt(cursor.getColumnIndex(KEY_level)));
                    students.add(s);
                } while(cursor.moveToNext());

            }
            return students;
            }catch (Exception e) {
            System.out.println("epurr epurr");
            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return null;
    }
}