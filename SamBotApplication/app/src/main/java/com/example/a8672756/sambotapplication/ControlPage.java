package com.example.a8672756.sambotapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class ControlPage extends AppCompatActivity {
    ImageButton stop;
    ImageButton up;
    ImageButton down;
    ImageButton right;
    ImageButton left;
    ImageButton option;
    ImageButton bluetooth;
    ListView dropDownMenu;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_page);

        stop = (ImageButton) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO BLUETOOTH : Check if the bluetooth is activated before sending data
                //TODO BLUETOOTH : If the bluetooth is disable, print a Toast on the screen
                //TODO BLUETOOTH : Send stop
            }
        });

        left = (ImageButton) findViewById(R.id.leftArrow);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO BLUETOOTH : Send left rotation
            }
        });

        right = (ImageButton) findViewById(R.id.rightArrow);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO BLUETOOTH : Send right rotation
            }
        });

        up = (ImageButton) findViewById(R.id.upArrow);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO BLUETOOTH : Send forward
            }
        });

        down = (ImageButton) findViewById(R.id.downArrow);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO BLUETOOTH : Send backward
            }
        });

        bluetooth = (ImageButton) findViewById(R.id.bluetooth);
        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO BLUETOOTH : enable bluetooth
                Intent intent = new Intent(ControlPage.this, ConnectionPage.class);
                startActivity(intent);
            }
        });

    }
}
