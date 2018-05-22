package com.example.a8672756.listapp;

import java.util.ArrayList;

/**
 * Created by 8672756 on 18/05/2018.
 */

class DataModel {
    private static final DataModel ourInstance = new DataModel();

    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayList<ArrayList> arrayList2 = new ArrayList<ArrayList>();
    int index;
    int editList = 0;
    static DataModel getInstance() {
        return ourInstance;
    }

    private DataModel() {

    }
}
