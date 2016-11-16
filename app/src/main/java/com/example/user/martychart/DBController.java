package com.example.user.martychart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 14/11/2016.
 */

public class DBController extends SQLiteOpenHelper {

    private static final String tablename = "medications"; //table name
    private static final String key_id = "ID"; //auto generated ID column
    private static final String key_name = "name"; //column name
    private static final String key_quantity = "quantity"; //column name
    private static final String key_date = "date"; //column name
    private static final String databasename = "medicationinfo"; //database name
    private static final int versioncode = 10; //version code of the database


    public DBController(Context context) {
        super(context, databasename, null, versioncode);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String query;
        query = "CREATE TABLE IF NOT EXISTS " + tablename +
                "(" + key_id + " integer primary key, " + key_name +
                " text, " + key_quantity + " integer, " + key_date + " integer)";
        database.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version){
        String query;
        query = "DROP TABLE IF EXISTS " + tablename;
        database.execSQL(query);
        onCreate(database);
    }

    //all CRUD operations

    //add new medication
    public void addMedication (Medication medication){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(key_name, medication.getName());
        contentValues.put(key_quantity, medication.getQuantity());
        contentValues.put(key_date, medication.getDate());

        //inserting row
        db.insert(tablename, null, contentValues);
        db.close();
    }

    // get single medication
    public Medication getMedication(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tablename, new String[]{key_id, key_name, key_quantity, key_date}, key_id + "=?",
                new String[] {String.valueOf(id) }, null, null, null, null); //need more nulls?
            if (cursor != null)
                cursor.moveToFirst();

        Medication medication = new Medication(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)));

        return medication;

    }

    //GET ALL MEDICATION

    public ArrayList<HashMap<String, String>> getAllMeds() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        Medication medication = new Medication();
        String selectQuery = "SELECT  * FROM " + tablename;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put(medication.getIdString(), cursor.getString(0));
                map.put(medication.getName(), cursor.getString(1));
                map.put(medication.getQuantityString(), cursor.getString(2));
                map.put(medication.getDateString(), cursor.getString(3));

                wordList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return wordList;
    }








//    public ArrayList<Medication> getAllMeds(){
//        ArrayList<Medication> medicationList = new ArrayList<Medication>();
//
//        String query = "SELECT * FROM " + tablename;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor.moveToFirst()){
//            do {
//                Medication medication = new Medication();
//                medication.setId(Integer.parseInt(cursor.getString(0)));
//                medication.setName(cursor.getString(1));
//                medication.setQuantity(Integer.parseInt(cursor.getString(2)));
//                medication.setDate(Integer.parseInt(cursor.getString(3)));
//                medicationList.add(medication);
//
//            } while (cursor.moveToNext());
//        }
//        return medicationList;
//    }

//    //get medication count
    public int getMedicationCount(){
        String countQuery = "SELECT * FROM " + tablename;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

//    //update single medication
//    public int updateMedication(Medication medication){
//
//    }
//
//    //delete single medication
//    public void deleteMedication(Medication medication){
//
//    }


//replaced by new method above
//    public ArrayList<HashMap<String, String>> getAllMedsOldMethod() {
//        ArrayList<HashMap<String, String>> wordList;
//        wordList = new ArrayList<HashMap<String, String>>();
//        String selectQuery = "SELECT  * FROM " + tablename;
//        SQLiteDatabase database = this.getWritableDatabase();
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            do {
//
//                HashMap<String, String> map = new HashMap<String, String>();
//                map.put("id", cursor.getString(0));
//                map.put("name  ", cursor.getString(1));
//                map.put("quantity", cursor.getString(2));
//                map.put("time", cursor.getString(3));
//
//                wordList.add(map);
//            } while (cursor.moveToNext());
//        }
//
//        return wordList;
//    }


}
