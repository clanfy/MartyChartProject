package com.example.user.martychart;

/**
 * Created by user on 15/11/2016.
 */

public class Medication {

    private int mId;
    private String mName;
    private int mQuantity;
    private int mDate;

    public Medication(){

    }

    public Medication(int id, String name, int quantity, int date){
        this.mId = id;
        this.mName = name;
        this.mQuantity = quantity;
        this.mDate = date;
    }

    public Medication(String name, int quantity, int date){
        this.mName = name;
        this.mQuantity = quantity;
        this.mDate = date;
    }



}
