package com.example.user.martychart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 14/11/2016.
 */

public class MedsList extends AppCompatActivity {

    DBController mController = new DBController(this);
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meds_list);


        mListView = (ListView) findViewById(R.id.meds_list);

        ArrayList<Medication> data = mController.getAllMeds();

        ArrayAdapter<Medication> adapter = new ArrayAdapter<Medication>(this, android.R.layout.simple_list_item_1, data);

        mListView.setAdapter(adapter);
    }
}


















