package com.team7.team7_school;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBDataSource {

    private SQLiteDatabase database;
    private MySqlLiteHelper databaseHelper;

    public DBDataSource(Context context) {
        databaseHelper = new MySqlLiteHelper(context);
    }

    public void open() {
        database = databaseHelper.getReadableDatabase();
    }

    public void close() {
        database.close();
    }

    public List<Buildings> getAllBuildings() {
        List<Buildings> build = new ArrayList<>();

        String[] columnNames = MySqlLiteHelper.BuildingColumn.names();

        Cursor cursor = database.query(MySqlLiteHelper.BUILDINGS_TABLE,
                columnNames,
                null, null, null, null, MySqlLiteHelper.BuildingColumn.Name.toString());

        cursor.moveToFirst();
        while (! cursor.isAfterLast()) {
            Buildings building = cursorToBuildings(cursor);
            build.add(building);
            cursor.moveToNext();
        }
        cursor.close();

        return build;
    }

    private Buildings cursorToBuildings(Cursor cursor) {
        Buildings building = new Buildings();

        String name = cursor.getString(MySqlLiteHelper.BuildingColumn.Name.ordinal());
        building.setName(name);

        int Building_ID = cursor.getInt(cursor.getColumnIndex(MySqlLiteHelper.BuildingColumn.
                Building_ID.toString()));
        building.setBuilding_ID(Building_ID);

        return building;
    }

    public List<Biology> getAllBiology() {
        List<Biology> bio = new ArrayList<>();

        String[] columnNames = MySqlLiteHelper.BiologyColumn.names();

        Cursor bio_cursor = database.query(MySqlLiteHelper.BIOLOGY_TABLE,
                columnNames,
                null, null, null, null, MySqlLiteHelper.BiologyColumn.biology_Name.toString());

        bio_cursor.moveToFirst();
        while (! bio_cursor.isAfterLast()) {
           Biology biology = cursorToBiology(bio_cursor);
            bio.add(biology);
            bio_cursor.moveToNext();
        }
        bio_cursor.close();

        return bio;
    }

    private Biology cursorToBiology(Cursor bio_cursor) {
        Biology biology = new Biology();

        String bio_name = bio_cursor.getString(MySqlLiteHelper.BiologyColumn.biology_Name.ordinal());
        biology.setBiology_Name(bio_name);

        biology.setBiology_Department(bio_cursor.getString(MySqlLiteHelper.BiologyColumn.biology_Department.ordinal()));
        biology.setBiology_Office(bio_cursor.getString(MySqlLiteHelper.BiologyColumn.biology_Office.ordinal()));
        biology.setBiology_Phone(bio_cursor.getString(MySqlLiteHelper.BiologyColumn.biology_Phone.ordinal()));
        biology.setBiology_Email(bio_cursor.getString(MySqlLiteHelper.BiologyColumn.biology_Email.ordinal()));

        return biology;
    }

    public List<ComputerScience> getAllComputerScience() {
        List<ComputerScience> com = new ArrayList<>();

        String[] columnNames = MySqlLiteHelper.ComputerScienceColumn.names();

        Cursor com_cursor = database.query(MySqlLiteHelper.COMPUTERSCIENCE_TABLE,
                columnNames,
                null, null, null, null, MySqlLiteHelper.ComputerScienceColumn.computerscience_Name.toString());

        com_cursor.moveToFirst();
        while (! com_cursor.isAfterLast()) {
            ComputerScience computerScience = cursorToComputerScience(com_cursor);
            com.add(computerScience);
            com_cursor.moveToNext();
        }
        com_cursor.close();

        return com;
    }

    private ComputerScience cursorToComputerScience(Cursor com_cursor) {
        ComputerScience computerScience = new ComputerScience();

        String com_name = com_cursor.getString(MySqlLiteHelper.ComputerScienceColumn.computerscience_Name.ordinal());
        computerScience.setComputerscience_Name(com_name);

        computerScience.setComputerscience_Department(com_cursor.getString(MySqlLiteHelper.ComputerScienceColumn.computerscience_Department.ordinal()));
        computerScience.setComputerscience_Office(com_cursor.getString(MySqlLiteHelper.ComputerScienceColumn.computerscience_Office.ordinal()));
        computerScience.setComputerscience_Phone(com_cursor.getString(MySqlLiteHelper.ComputerScienceColumn.computerscience_Phone.ordinal()));
        computerScience.setComputerscience_Email(com_cursor.getString(MySqlLiteHelper.ComputerScienceColumn.computerscience_Email.ordinal()));

        return computerScience;
    }

    public List<Math> getAllMath() {
        List<Math> m = new ArrayList<>();

        String[] columnNames = MySqlLiteHelper.MathColumn.names();

        Cursor math_cursor = database.query(MySqlLiteHelper.MATH_TABLE,
                columnNames,
                null, null, null, null, MySqlLiteHelper.MathColumn.math_Name.toString());

        math_cursor.moveToFirst();
        while (! math_cursor.isAfterLast()) {
            Math math = cursorToMath(math_cursor);
            m.add(math);
            math_cursor.moveToNext();
        }
        math_cursor.close();

        return m;
    }

    private Math cursorToMath(Cursor math_cursor) {
        Math math = new Math();

        String math_name = math_cursor.getString(MySqlLiteHelper.MathColumn.math_Name.ordinal());
        math.setMath_Name(math_name);

        math.setMath_Department(math_cursor.getString(MySqlLiteHelper.MathColumn.math_Department.ordinal()));
        math.setMath_Office(math_cursor.getString(MySqlLiteHelper.MathColumn.math_Office.ordinal()));
        math.setMath_Phone(math_cursor.getString(MySqlLiteHelper.MathColumn.math_Phone.ordinal()));
        math.setMath_Email(math_cursor.getString(MySqlLiteHelper.MathColumn.math_Email.ordinal()));

        return math;

    }
}
