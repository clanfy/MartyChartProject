package com.example.user.martychart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 14/11/2016.
 */

public class MCApp extends AppCompatActivity {

    DBController mController = new DBController(this);
    Button mAdd, mView, mUpdate, mDelete;
    EditText mMedId, mMedicine, mQuantity, mTime;
    TextView mInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
    }

}
