package com.example.a8672756.sambotapplication;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

class DataModel {
    private static final DataModel ourInstance = new DataModel();

    public  ArrayList<String> arrayList = new ArrayList<>();
    int index;

    public ArrayList<String> deviceList = new ArrayList<>();

    static DataModel getInstance() {

        return ourInstance;
    }

    private DataModel() {
    }
}
