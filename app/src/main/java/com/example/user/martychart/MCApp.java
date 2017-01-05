package com.example.user.martychart;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
    Button mAdd, mView;
    EditText mMedId, mName, mQuantity, mDate;
    TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MCApp", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMedId = (EditText) findViewById(R.id.etmedid);
        mName = (EditText) findViewById(R.id.etname);
        mQuantity = (EditText) findViewById(R.id.etquantity);
        mDate = (EditText) findViewById(R.id.etdate);
        mAdd = (Button) findViewById(R.id.btnadd);
        mView = (Button) findViewById(R.id.btnview);
        mResultText = (TextView) findViewById(R.id.txtresulttext);

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MCApp.this, MedsList.class);
                Log.d("View meds list:", "list clicked");
                startActivity(intent);
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mName.getText().toString().trim().equals("") || mQuantity.getText().toString().trim().equals("")) {
                        mResultText.setText("Please enter medication");
                    } else {
                        mController = new DBController(getApplicationContext());
                        SQLiteDatabase db = mController.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("name", mName.getText().toString());
                        contentValues.put("quantity", mQuantity.getText().toString());
                        contentValues.put("date", mDate.getText().toString());
                        db.insert("medications", null, contentValues);
                        db.close();
                        mResultText.setText("Medication added successfully");
                    }
                } catch (Exception exception) {
                    mResultText.setText(exception.getMessage().toString());
                }
            }

        });
    }}

