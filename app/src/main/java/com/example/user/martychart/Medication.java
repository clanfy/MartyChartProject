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

    //getting id as string
    public String getIdString(){
        return Integer.toString(this.mId);
    }

    //setting id
    public void setId(int id){
        this.mId = id;
    }

    //getting name
    public String getName(){
        return this.mName;
    }

    //setting name
    public void setName(String name){
        this.mName = name;
    }

    //getting quantity
    public int getQuantity(){
        return this.mQuantity;
    }

    //setting quantity
    public void setQuantity(int quantity){
        this.mQuantity = quantity;
    }

    //getting date
    public int getDate(){
        return this.mDate;
    }

    //setting date
    public void setDate(int date){
        this.mDate = date;
    }

}
