package com.example.a8672756.sambotapplication;

import java.util.ArrayList;

class DataModel {
    private static final DataModel ourInstance = new DataModel();

    public  ArrayList<String> arrayList = new ArrayList<>();

    static DataModel getInstance() {

        return ourInstance;
    }

    private DataModel() {
    }
}
