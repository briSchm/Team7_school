package com.team7.team7_school;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    //add table keys
    public static final String KEY_ROWID = "rowid";
    public static final String KEY_DEPARTMENT = "Department";
    public static final String KEY_NAME = "Name";
    public static final String KEY_OFFICE = "Office";
    public static final String KEY_PHONE = "Phone";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_SPEC = "Specialty";


    private static final String DATABASE_NAME = "majors.sqlite";
    private static final int DB_VERSION = 1;

    public static final String COMPUTERSCIENCE_TABLE = "Computer Science";
    public static final String MATH_TABLE = "Math";
    public static final String BIOLOGY_TABLE = "Biology";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.financeaid) {
            return true;
        }
        if (id == R.id.about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}