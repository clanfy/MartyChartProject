package com.example.user.martychart;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 14/11/2016.
 */

public class DBController extends SQLiteOpenHelper {

    private static final String tablename = "medications"; //table name
    private static final String id = "ID"; //auto generated ID column
    private static final String medicine = "medicine"; //column name
    private static final String quantity = "quantity"; //column name
    private static final String date = "date"; //column name
    private static final String databasename = "medicationinfo"; //database name
    private static final int versioncode = 7; //version code of the database


    public DBController(Context context) {
        super(context, databasename, null, versioncode);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String query;
        query = "CREATE TABLE IF NOT EXISTS " + tablename +
                "(" + id + " integer primary key, " + medicine +
                " text, " + quantity + " integer, " + date + " integer)";
        database.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version){
        String query;
        query = "DROP TABLE IF EXISTS " + tablename;
        database.execSQL(query);
        onCreate(database);
    }

    public ArrayList<HashMap<String, String>> getAllMeds() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", cursor.getString(0));
                map.put("medicine", cursor.getString(1));
                map.put("quantity", cursor.getString(2));
                map.put("time", cursor.getString(3));

                wordList.add(map);
            } while (cursor.moveToNext());
        }

        return wordList;
    }


}
