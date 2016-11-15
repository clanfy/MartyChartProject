package com.example.user.martychart;

/**
 * Created by user on 15/11/2016.
 */

public class Medication {

    //private variables
    private int mId;
    private String mName;
    private int mQuantity;
    private int mDate;

    //empty constructor
    public Medication(){

    }

    //constructor
    public Medication(int id, String name, int quantity, int date){
        this.mId = id;
        this.mName = name;
        this.mQuantity = quantity;
        this.mDate = date;
    }

    //constructors
    public Medication(String name, int quantity, int date){
        this.mName = name;
        this.mQuantity = quantity;
        this.mDate = date;
    }

    //getting id
    public int getId(){
        return this.mId;
    }

    //setting id
    public void setId(int id){
        this.mId = id;
    }

    //getting name

    //setting name

    //getting quantity

    //setting quantity

    //getting date

    //setting date

}
