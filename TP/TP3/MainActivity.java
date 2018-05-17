package com.example.toanphamtran.applicationexercisephoto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText use;
    EditText pass;
    Button Buttonlogin;
    ImageView imageTroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        use = (EditText)
                findViewById(R.id.editTextUser);

        pass = (EditText)
                findViewById(R.id.editTextPass);

        imageTroll = (ImageView)
                findViewById(R.id.imageViewPhoto);
        imageTroll.setImageResource(R.drawable.fail);
        imageTroll.setVisibility(View.INVISIBLE);

        Buttonlogin = (Button)
                findViewById(R.id.buttonLog);
        Buttonlogin.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = use.getText().toString();
                String password = pass.getText().toString();
                if ((user.equalsIgnoreCase("user")) &&
                        (password.equalsIgnoreCase("pass"))){

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                    imageTroll.setVisibility(View.INVISIBLE);
                } else{

                    imageTroll.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,
                            "YOU FAILED",Toast.LENGTH_SHORT )
                            .show();
                }


            }
        });



    }
}
