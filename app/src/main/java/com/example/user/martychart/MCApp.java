package com.example.user.martychart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 14/11/2016.
 */

public class MCApp extends AppCompatActivity {

    DBController mController = new DBController(this);
    Button mAdd, mView, mUpdate, mDelete;
    EditText mMedId, mMedicine, mQuantity, mDate;
    TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        Log.d("MCApp", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMedId = (EditText) findViewById(R.id.etmedid);
        mMedicine = (EditText) findViewById(R.id.etmed);
        mQuantity = (EditText) findViewById(R.id.etquantity);
        mDate = (EditText) findViewById(R.id.etdate);

        mAdd = (Button) findViewById(R.id.btnadd);
        mView = (Button) findViewById(R.id.btnview);
        mUpdate = (Button) findViewById(R.id.btnupdate);
        mDelete = (Button) findViewById(R.id.btndelete);

        mResultText = (TextView) findViewById(R.id.txtresulttext);

        mView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MCApp.this, MedsList.class);
                startActivity(intent);
            }
        });

    }

}
