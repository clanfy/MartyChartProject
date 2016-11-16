package com.example.user.martychart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
    TextView mInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meds_list);


        mListView = (ListView) findViewById(R.id.meds_list);
        mInfoText = (TextView) findViewById(R.id.txtresulttext);

        try {
            List<HashMap<String, String>> data = mController.getAllMeds();//get all meds method
            Doseable medication = new Medication();
            if (data.size() != 0) {
                SimpleAdapter adapter = new SimpleAdapter(MedsList.this, data,
                        R.layout.rows,
                        new String[]{medication.getIdString(), medication.getName(), medication.getQuantityString(), medication.getDateString()},
                        new int[]{R.id.etmedid, R.id.etname, R.id.etquantity, R.id.etdate});

                mListView.setAdapter(adapter);
                String length = String.valueOf(data.size());
                mInfoText.setText(length + " Medications taken");
            } else {
                mInfoText.setText("No medications added");
            }

        } catch (Exception exception) {
            mInfoText.setText(exception.getMessage());
        }
    }
}


    //TODO: onCreateOptionsMenu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        return true;
//    }

    //TODO: OnOptionsItemSelected
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        return true;
//    }
















