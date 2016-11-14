package com.example.user.martychart;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
                Log.d("View meds list:", "list clicked");
                startActivity(intent);
            }
        });

        mAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    if (mMedicine.getText().toString().trim().equals("") || mQuantity.getText().toString().trim().equals("")){
                        mResultText.setText("Please enter medication");
                    } else {
                        mController = new DBController(getApplicationContext());
                        SQLiteDatabase db = mController.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("medicine", mMedicine.getText().toString());
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

        mUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    if ((mMedicine.getText().toString().trim().equals("") && mQuantity.getText().toString().trim().equals("")) || mMedId.getText().toString().trim().equals("")){
                        mResultText.setText("Please insert values to update");
                    } else{
                        mController = new DBController(getApplicationContext());
                        SQLiteDatabase db = mController.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("medicine", mMedicine.getText().toString());
                        contentValues.put("quantity", mQuantity.getText().toString());
                        contentValues.put("date", mDate.getText().toString());

                        db.update("medications", contentValues, "id=" + mMedId.getText().toString(), null);

                        Toast.makeText(MCApp.this, "Medication input updated successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception exception) {
                    mResultText.setText(exception.getMessage().toString());
                }
            }
        });

        mDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    if (mMedId.getText().toString().trim().equals("")) {
                        mResultText.setText("Please insert ID to delete");
                    } else {
                        mController = new DBController(getApplicationContext());
                        SQLiteDatabase db = mController.getWritableDatabase();

                        db.delete("medications", "id=" + mMedId.getText().toString(), null);

                        Toast.makeText(MCApp.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception exception) {
                    mResultText.setText(exception.getMessage().toString());
                }
            }
        });
    }

    //TODO: onCreateOptionsMenu
//    @Override
//    public boolean onCreateOptionsMenu (Menu menu){
//        return true;
//    }

    //TODO: onOptionsItemsSelected

//    @Override
//    public boolean onOptionsItemsSelected(MenuItem item){
//        return true;
//    }


}
