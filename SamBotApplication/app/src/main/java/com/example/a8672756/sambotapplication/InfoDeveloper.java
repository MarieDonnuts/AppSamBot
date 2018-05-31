package com.example.a8672756.sambotapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class InfoDeveloper extends AppCompatActivity {

    TextView developer;
    TextView infos;
    ImageView photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_developer);

        developer = (TextView) findViewById(R.id.textViewDeveloper);
        developer.setText(DataModel.getInstance().developer);

        infos = (TextView) findViewById(R.id.textViewInfo);
        photo = (ImageView) findViewById(R.id.imageViewDeveloper);

        if (DataModel.getInstance().developer == "Marie"){
            infos.setText("Marie is 22 years old, \nShe likes programing and sport");
            photo.setImageResource(R.drawable.photo_marie);
            photo.setVisibility(View.VISIBLE);
        }

        if (DataModel.getInstance().developer == "Rodolphe"){
            infos.setText("Rodolphe is 23 years old, \nHe likes ...");
            photo.setImageResource(R.drawable.photo_rodolphe);
            photo.setVisibility(View.VISIBLE);
        }

        if (DataModel.getInstance().developer == "Toan"){
            infos.setText("Toan is 21 years old, \nHe likes ...");
            photo.setImageResource(R.drawable.photo_toan);
            photo.setVisibility(View.VISIBLE);
        }
    }
}
