package com.example.user.martychart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 14/11/2016.
 */

public class DBController extends SQLiteOpenHelper {

    private static final String tablename = "medication"; //table name
    private static final String medication = "medication"; //column name
    private static final String id = "ID"; //auto generated ID column
    private static final String databasename = "medicationinfo"; //database name
    private static final int versioncode = 1; //version code of the database
    //will also need quantity and time taken

    public DBController(Context context) {
        super(context, databasename, null, versioncode);
    }

    @Override
    public void OnCreate(SQLiteDatabase database){
        String query;
        query = "CREATE TABLE IF NOT EXISTS " + tablename + "(" + id + "integer primary key, " + medication + " text)";
        database.execSQL(query);
    }





}
