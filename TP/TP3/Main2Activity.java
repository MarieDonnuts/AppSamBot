package com.example.toanphamtran.applicationexercisephoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Button buttonLeft;
    Button buttonRight;
    ImageView image;
    EditText comment1;
    EditText comment2;
    EditText comment3;
    EditText comment4;
    EditText comment5;
    TextView title;
    TextView counter;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = (TextView) findViewById(R.id.textViewTitle);

        counter = (TextView) findViewById(R.id.counter);

        comment1 = (EditText) findViewById(R.id.comment1);
        comment2 = (EditText) findViewById(R.id.comment2);
        comment3 = (EditText) findViewById(R.id.comment3);
        comment4 = (EditText) findViewById(R.id.comment4);
        comment5 = (EditText) findViewById(R.id.comment5);
        comment2.setVisibility(View.INVISIBLE);
        comment3.setVisibility(View.INVISIBLE);
        comment4.setVisibility(View.INVISIBLE);
        comment5.setVisibility(View.INVISIBLE);

        image = (ImageView) findViewById(R.id.photos);

        buttonLeft = (Button) findViewById(R.id.buttonLeft);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 1){
                    i = 5;
                }
                else{
                    i--;
                }
                switcher(i);

            }
        });

        buttonRight = (Button) findViewById(R.id.buttonRight);
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 5){
                    i = 1;
                }
                else{
                    i++;
                }
                switcher(i);
            }
        });
        }

    private void switcher(int i){
        switch(i){
            case 1 :
                image.setImageResource(R.drawable.lama);
                image.setVisibility(View.VISIBLE);
                title.setText("Lama");
                counter.setText("1 / 5");
                comment1.setVisibility(View.VISIBLE);
                comment2.setVisibility(View.INVISIBLE);
                comment3.setVisibility(View.INVISIBLE);
                comment4.setVisibility(View.INVISIBLE);
                comment5.setVisibility(View.INVISIBLE);

                break;
            case 2 :
                image.setImageResource(R.drawable.autruche);
                image.setVisibility(View.VISIBLE);
                title.setText("Ostrich");
                counter.setText("2 / 5");
                comment1.setVisibility(View.INVISIBLE);
                comment2.setVisibility(View.VISIBLE);
                comment3.setVisibility(View.INVISIBLE);
                comment4.setVisibility(View.INVISIBLE);
                comment5.setVisibility(View.INVISIBLE);
                break;
            case 3 :
                image.setImageResource(R.drawable.giraffe);
                image.setVisibility(View.VISIBLE);
                title.setText("Giraffe");
                counter.setText("3 / 5");
                comment1.setVisibility(View.INVISIBLE);
                comment2.setVisibility(View.INVISIBLE);
                comment3.setVisibility(View.VISIBLE);
                comment4.setVisibility(View.INVISIBLE);
                comment5.setVisibility(View.INVISIBLE);
                break;
            case 4 :
                image.setImageResource(R.drawable.rhino);
                image.setVisibility(View.VISIBLE);
                title.setText("Rhinoceros");
                counter.setText("4 / 5");
                comment1.setVisibility(View.INVISIBLE);
                comment2.setVisibility(View.INVISIBLE);
                comment3.setVisibility(View.INVISIBLE);
                comment4.setVisibility(View.VISIBLE);
                comment5.setVisibility(View.INVISIBLE);
                break;
            case 5 :
                image.setImageResource(R.drawable.singe);
                image.setVisibility(View.VISIBLE);
                title.setText("Monkey");
                counter.setText("5 / 5");
                comment1.setVisibility(View.INVISIBLE);
                comment2.setVisibility(View.INVISIBLE);
                comment3.setVisibility(View.INVISIBLE);
                comment4.setVisibility(View.INVISIBLE);
                comment5.setVisibility(View.VISIBLE);
                break;
        }

    }
}
