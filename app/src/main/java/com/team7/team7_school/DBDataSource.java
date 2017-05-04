package com.team7.team7_school;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBDataSource {

    private SQLiteDatabase database;
    private MySqlLiteHelper databaseHelper;

    public DBDataSource(Context context) {
        databaseHelper = new MySqlLiteHelper(context);
    }

    public void open() {
        database = databaseHelper.getReadableDatabase();
    }
}
