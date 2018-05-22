package com.example.a8672756.sambotapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ControlPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_page);
    }
    public void swipeInfoPage(View v){
        Intent intent = new Intent(ControlPage.this, InfoPage.class);
        startActivity(intent);
    }
}
