package com.example.a8672756.sambotapplication;

import java.util.ArrayList;

/**
 * @author  DONNET Marie
 * @author PHAM TRAN Toan
 * @author LATOUR Rodolphe
 * @author Class to create the data model for the connection page
 *  Create on may 24 2018
 *
 */
class DataConnectionPage {
    private static final DataConnectionPage ourInstance = new DataConnectionPage();
    ArrayList<String> arrayList = new ArrayList<String>();

    //variable device chosen
    int deviceChosen;
    static DataConnectionPage getInstance() {
        return ourInstance;
    }

    private DataConnectionPage() {
    }
}
