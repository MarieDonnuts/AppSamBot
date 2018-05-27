package com.example.mariedonnet.info_developer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoDeveloper extends AppCompatActivity {

    TextView developer;
    TextView infoDeveloper;
    ImageView photo;
    Button right;
    Button left;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_developer);

        developer = (TextView) findViewById(R.id.textViewDeveloper);

        infoDeveloper = (TextView) findViewById(R.id.textViewInfo);

        photo = (ImageView) findViewById(R.id.imageViewDeveloper);

        left = (Button) findViewById(R.id.buttonLeft);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1){
                    i = 3;
                }
                else{
                    i--;
                }
                switcher(i);
            }
        });

        right = (Button) findViewById(R.id.buttonRight);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 3){
                    i = 1;
                }
                else{
                    i++;
                }
                switcher(i);
            }
        });
    }
    private void switcher(int i) {
        switch (i) {
            case 1:
                developer.setText("Marie");
                photo.setImageResource(R.drawable.photo_marie);
                photo.setVisibility(View.VISIBLE);
                infoDeveloper.setText("Marie is 22 years old \n She likes programing and sport");
                break;
            case 2:
                developer.setText("Rodolphe");
                photo.setImageResource(R.drawable.photo_rodolphe);
                photo.setVisibility(View.VISIBLE);
                infoDeveloper.setText("Rodolphe is 23 years old \n He likes ...");
                break;
            case 3:
                developer.setText("Toan");
                photo.setImageResource(R.drawable.photo_toan);
                photo.setVisibility(View.VISIBLE);
                infoDeveloper.setText("Marie is 21 years old \n He likes ...");
                break;
        }
    }
}
