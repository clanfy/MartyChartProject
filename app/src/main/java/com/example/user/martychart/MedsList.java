package com.example.user.martychart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 14/11/2016.
 */

public class MedsList extends AppCompatActivity {

    DBController mcontroller = new DBController(this);
    ListView mListView;
    TextView mInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meds_list);

        mListView = (ListView) findViewById(R.id.medslist);
        mInfoText = (TextView) findViewById(R.id.txtresulttext);

        try{
            List<HashMap<String, String>> data = mcontroller.getAllMeds();
            if (data.size()) != 0){
                SimpleAdapter adapter = new SimpleAdapter(MedsList.this, data, R.layout.rows, new String[]{"id", "medicine", "quantity", "time"}, new int[]{
                        R.id.etmedid, R.id.etmed, R.id.etquantity, R.id.etdate});
            }



        }

    }



    }


