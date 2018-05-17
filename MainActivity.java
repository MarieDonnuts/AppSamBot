package com.example.toanphamtran.calculatorexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;

    EditText num1;
    EditText num2;

    Button add;
    Button sub;
    Button mult ;
    Button divide ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)
                findViewById(R.id.Result);
        result.setText("0");

        num1 = (EditText)
                findViewById(R.id.editNumber1);
        num1.setText("");
        num2 = (EditText)
                findViewById(R.id.editNumber2);
        num2.setText("");

        add = (Button)
                findViewById(R.id.buttonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.
                        parseInt(num1.getText().toString());
                int number2 = Integer.
                        parseInt(num2.getText().toString());
                int sum = number1 + number2 ;
                result.setText(""+sum);
            }
        });

        sub = (Button)
                findViewById(R.id.buttonSub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.
                        parseInt(num1.getText().toString());
                int number2 = Integer.
                        parseInt(num2.getText().toString());
                int less = number1 - number2 ;
                result.setText("" +less);
            }
        });

        mult = (Button)
                findViewById(R.id.buttonMult);
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.
                        parseInt(num1.getText().toString());
                int number2 = Integer.
                        parseInt(num2.getText().toString());
                int multi = number1 * number2 ;
                result.setText(""+multi);
            }
        });

        divide = (Button)
                findViewById(R.id.buttonDiv);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.
                        parseFloat(num1.getText().toString());
                float number2 = Float.
                        parseFloat(num2.getText().toString());
                float div = number1 / number2 ;
                result.setText(""+div);
            }
        });


    }
}
