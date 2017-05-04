package com.team7.team7_school;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Computer extends ListActivity {

    private DBDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataSource = new DBDataSource(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();

        dataSource.open();

        List<ComputerScience> com = dataSource.getAllComputerScience();

        ArrayAdapter<ComputerScience> adapter = new ArrayAdapter<ComputerScience>(getApplicationContext(),
                R.layout.lists, com);

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ArrayAdapter<ComputerScience> adapter = (ArrayAdapter<ComputerScience>) getListAdapter();

        ComputerScience computerscience = adapter.getItem(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(Html.fromHtml("<html>" +
                "<p><b>Department:</b> " + computerscience.getComputerscience_Department() + "</p>" +
                "<p><b>Name: </b> " + computerscience.getComputerscience_Name() + "</p>" +
                "<p><b>Office: </b> " + computerscience.getComputerscience_Office() + "</p>" +
                "<p><b>Phone: </b> " + computerscience.getComputerscience_Phone() + "</p>" +
                "<p><b>Email </b> " + computerscience.getComputerscience_Email() + "</p>" +
                "</html>")).
                setTitle("City Info").
                setPositiveButton("OK", null);
        builder.create().show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dataSource.close();
    }

}

