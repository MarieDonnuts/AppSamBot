package com.example.a8672756.sambotapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author  DONNET Marie
 * @author PHAM TRAN Toan
 * @author LATOUR Rodolphe
 * @author Class to create the control of brightness screen
 *  Create on may 23 2018
 *
 */

public class InfoPage extends AppCompatActivity {

    //Initiate the variable
    Button buttonMarie;
    Button buttonRodolphe;
    Button buttonToan;
    Button buttonConnection;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        //Set the button for Marie information
        buttonMarie = (Button) findViewById(R.id.buttonMarie);
        buttonMarie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPage.this, InfoDeveloper.class);
                startActivity(intent);
                DataModel.getInstance().developer = "Marie";
            }
        });
        //Set the button for Rodolphe information
        buttonRodolphe = (Button) findViewById(R.id.buttonRodolphe);
        buttonRodolphe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPage.this, InfoDeveloper.class);
                startActivity(intent);
                DataModel.getInstance().developer = "Rodolphe";
            }
        });

        //Set the button for Toan information
        buttonToan = (Button) findViewById(R.id.buttonToan);
        buttonToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPage.this, InfoDeveloper.class);
                startActivity(intent);
                DataModel.getInstance().developer = "Toan";
            }
        });

        //Set the button to go to the Control Page
        buttonConnection = (Button) findViewById(R.id.buttonMainMenu);
        buttonConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPage.this, ControlPage.class);
                startActivity(intent);
            }
        });
    }
}
