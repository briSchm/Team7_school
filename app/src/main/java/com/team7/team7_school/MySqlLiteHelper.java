package com.team7.team7_school;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MySqlLiteHelper extends SQLiteOpenHelper {

    private static final String DB_Name = "majors.sqlite";

    private static final String DB_VERSION_KEY = "db_ver";
    private static final int DB_VERSION = 1;

    public static final String BUILDINGS_TABLE = "buildings";
    public static final String COMPUTERSCIENCE_TABLE = "computerscience";
    public static final String BIOLOGY_TABLE = "biology";
    public static final String MATH_TABLE = "math";

    public enum BuildingColumn {
        Building_ID, Name;

        public static String[] names() {
            BuildingColumn[] v = values();
            String[] names = new String[v.length];
            for (int i = 0; i < v.length; i++) {
                names[i] = v[i].toString();
            }
            return names;
        }
    }

    public enum ComputerScienceColumn {
        computerscience_Department, computerscience_Name, computerscience_Office,
        computerscience_Phone, computerscience_Email;

        public static String[] names() {
            ComputerScienceColumn[] v = values();
            String[] names = new String[v.length];
            for (int i = 0; i < v.length; i++) {
                names[i] = v[i].toString();
            }
            return names;
        }
    }

    public enum BiologyColumn {
        biology_Department, biology_Name, biology_Office,
        biology_Phone, biology_Email;

        public static String[] names() {
            BiologyColumn[] v = values();
            String[] names = new String[v.length];
            for (int i = 0; i < v.length; i++) {
                names[i] = v[i].toString();
            }
            return names;
        }
    }

    public enum MathColumn {
        math_Department, math_Name, math_Office,
        math_Phone, math_Email, math_Spec;

        public static String[] names() {
           MathColumn[] v = values();
            String[] names = new String[v.length];
            for (int i = 0; i < v.length; i++) {
                names[i] = v[i].toString();
            }
            return names;
        }
    }

    private Context context;

    public MySqlLiteHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
        this.context = context;

        checkDatabase();
    }

    private void checkDatabase() {
        if (databaseExists()) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            int dbVersion = preferences.getInt(DB_VERSION_KEY, 0);
            if (DB_VERSION != dbVersion) {
                File database = getDatabaseFile();
                database.delete();
            }
        }
        if (!databaseExists()) {
            createDatabaseDir();
            createDatabase();
        }
    }

    private void createDatabaseDir() {
        File database = getDatabaseFile();
        File directory = database.getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private void createDatabase() {
        try {
            InputStream inputStream = context.getAssets().open(DB_Name);

            File database = getDatabaseFile();
            OutputStream outputStream = new FileOutputStream(database);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(DB_VERSION_KEY, DB_VERSION);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean databaseExists() {
        File database = getDatabaseFile();
        return database.exists();
    }

    private File getDatabaseFile() {
        return context.getDatabasePath(DB_Name);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // DO NOT DO A COPY HERE
        // DATABASE IS ALREADY OPEN - TOO LATE!!!
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        // DO NOT DO A COPY HERE
        // DATABASE IS ALREADY OPEN - TOO LATE!!!
    }
}
