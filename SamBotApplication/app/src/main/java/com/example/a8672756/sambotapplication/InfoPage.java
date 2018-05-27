package com.example.a8672756.sambotapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoPage extends AppCompatActivity {

    Button buttonMarie;
    Button buttonRodolphe;
    Button buttonToan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        buttonMarie = (Button) findViewById(R.id.buttonMarie);
        buttonMarie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPage.this, InfoDeveloper.class);
                startActivity(intent);
                DataModel.getInstance().developer = "Marie";
            }
        });

        buttonRodolphe = (Button) findViewById(R.id.buttonRodolphe);
        buttonRodolphe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPage.this, InfoDeveloper.class);
                startActivity(intent);
                DataModel.getInstance().developer = "Rodolphe";
            }
        });

        buttonToan = (Button) findViewById(R.id.buttonToan);
        buttonToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoPage.this, InfoDeveloper.class);
                startActivity(intent);
                DataModel.getInstance().developer = "Toan";
            }
        });
    }
}
