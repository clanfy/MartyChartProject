package com.example.user.martychart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
            List<HashMap<String, String>> data = mController.getAllMeds();
            if (data.size() != 0) {
                SimpleAdapter adapter = new SimpleAdapter(MedsList.this, data,
                        R.layout.rows, new String[]{"id", "medicine", "quantity", "time"},
                        new int[]{R.id.etmedid, R.id.etmed, R.id.etquantity, R.id.etdate});

                mListView.setAdapter(adapter);
                String length = String.valueOf(data.size());
                mInfoText.setText(length + " Medications taken");
            } else {
                mInfoText.setText("No medications added");
            }

        } catch (Exception exception) {
            mInfoText.setText(exception.getMessage().toString());
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

}














