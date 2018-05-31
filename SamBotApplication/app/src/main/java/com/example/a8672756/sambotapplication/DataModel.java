package com.example.a8672756.sambotapplication;

import java.util.ArrayList;

/**
 * @author  DONNET Marie
 * @author PHAM TRAN Toan
 * @author LATOUR Rodolphe
 * @author Class to create the data model for the control page
 *  Create on may 24 2018
 *
 */
class DataModel {
    private static final DataModel ourInstance = new DataModel();

    public  ArrayList<String> arrayList = new ArrayList<>();

    //variable index
    int index;
    //Variable developer
    String developer;


    static DataModel getInstance() {

        return ourInstance;
    }
    //Method which add 3 items to the arraylist
    private DataModel() {
        arrayList.add("Connection page");
        arrayList.add("Developer information");
        arrayList.add("Light control");
    }
}
