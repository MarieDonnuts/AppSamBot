package com.example.a8672756.sambotapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

/**
 * @author  DONNET Marie
 * @author PHAM TRAN Toan
 * @author LATOUR Rodolphe
 * Class to create the Main activity of our application
 * Create on may 27 2018
 *
 */

public class InfoDeveloper extends AppCompatActivity {

    //Variable declaration
    TextView developer;
    TextView infos;
    ImageView photo;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_developer);

        //Set the text view for the developer information
        developer = (TextView) findViewById(R.id.textViewDeveloper);
        developer.setText(DataModel.getInstance().developer);

        //Set the text view for the  information
        infos = (TextView) findViewById(R.id.textViewInfo);
        //Set the developer image
        photo = (ImageView) findViewById(R.id.imageViewDeveloper);

        //Set the data of the developer Marie
        if (DataModel.getInstance().developer == "Marie"){
            infos.setText("Marie is 22 years old, \nShe likes programing and sport");
            photo.setImageResource(R.drawable.photo_marie);
            photo.setVisibility(View.VISIBLE);
        }
        //Set the data of the developer Rodolphe
        if (DataModel.getInstance().developer == "Rodolphe"){
            infos.setText("Rodolphe is 23 years old, \nHe plays music and composes");
            photo.setImageResource(R.drawable.photo_rodolphe);
            photo.setVisibility(View.VISIBLE);
        }

        //Set the data of the developer
        if (DataModel.getInstance().developer == "Toan"){
            infos.setText("Toan is 21 years old, \nHe likes making jokes and chinese food");
            photo.setImageResource(R.drawable.photo_toan);
            photo.setVisibility(View.VISIBLE);
        }
    }
}
