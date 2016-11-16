package com.example.user.martychart;

/**
 * Created by user on 15/11/2016.
 */

public class Medication implements Doseable {

    //private variables
    private int mId;
    private String mName;
    private String mQuantity;
    private String mDate;

    //empty constructor
    public Medication(){

    }

    //constructor
    public Medication(int id, String name, String quantity, String date){
        this.mId = id;
        this.mName = name;
        this.mQuantity = quantity;
        this.mDate = date;
    }

    //constructors
    public Medication(String name, String quantity, String date){
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
    public String getQuantity(){
        return this.mQuantity;
    }

    //getting quantity as string
//    public String getQuantityString(){
//        return Integer.toString(this.getQuantity());
//    }

    //setting quantity
    public void setQuantity(String quantity){
        this.mQuantity = quantity;
    }

    //getting date
    public String getDate(){
        return this.mDate;
    }

    //getting date as string
//    public String getDateString(){
//        return Integer.toString(this.getDate());
//    }

    //setting date
    public void setDate(String date){
        this.mDate = date;
    }

    public String toString(){
        return "MEDICATION: " + this.mName + "\n" + "QUANTITY: " + this.mQuantity + "\n" + "TIME TAKEN: " + this.mDate;
    }

}
