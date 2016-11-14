package com.example.user.martychart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 14/11/2016.
 */

public class DBController extends SQLiteOpenHelper {

    private static final String tablename = "medication"; //table name
    private static final String id = "ID"; //auto generated ID column
    private static final String medication = "medication"; //column name
    private static final String quantity = "quantity"; //column name
    private static final String datetime = "date time"; //column name
    private static final String databasename = "medicationinfo"; //database name
    private static final int versioncode = 1; //version code of the database


    public DBController(Context context) {
        super(context, databasename, null, versioncode);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String query;
        query = "CREATE TABLE IF NOT EXISTS " + tablename +
                "(" + id + "integer primary key, " + medication +
                " text," + quantity + " text," + datetime + " text)";
        database.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version){
        String query;
        query = "DROP TABLE IF EXISTS " + tablename;
        database.execSQL(query);
        onCreate(database);
    }





}
