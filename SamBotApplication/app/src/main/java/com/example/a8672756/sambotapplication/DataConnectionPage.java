package com.example.a8672756.sambotapplication;

import java.util.ArrayList;

/**
 * Created by 8672756 on 24/05/2018.
 */

class DataConnectionPage {
    private static final DataConnectionPage ourInstance = new DataConnectionPage();
    ArrayList<String> arrayList = new ArrayList<String>();
    int deviceChosen;
    static DataConnectionPage getInstance() {
        return ourInstance;
    }

    private DataConnectionPage() {
    }
}
