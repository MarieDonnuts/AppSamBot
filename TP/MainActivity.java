package com.example.a8672756.sambot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textViewCounter;
    TextView result;
    EditText num1;
    EditText num2;
    Button add;
    Button substract;
    Button multiply;
    Button divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)
                findViewById(R.id.Result);
        result.setText("0");

        num1 = (EditText)
                findViewById(R.id.Number1);
        num1.setText("");

        num2 = (EditText)
                findViewById(R.id.Number2);
        num2.setText("");

        add = (Button)
                findViewById(R.id.Add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.
                        parseInt(num1.getText().toString());
                int number2 = Integer.
                        parseInt(num2.getText().toString());
                int sum = number1 + number2;
                result.setText("" + sum);
            }
        });



    }
}
