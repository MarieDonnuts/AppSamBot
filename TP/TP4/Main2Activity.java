package com.example.a8672756.listapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    EditText name;
    EditText price;
    EditText quantity;
    Button ok;

    String nameValue;
    float priceValue;
    int qtValue;

    ArrayList list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = (EditText) findViewById(R.id.editTextName);
        price = (EditText) findViewById(R.id.editTextPrice);
        quantity = (EditText) findViewById(R.id.editTextQt);

        if (!DataModel.getInstance().arrayList2.isEmpty() && DataModel.getInstance().editList == 1){
            name.setText(DataModel.getInstance().arrayList2.get(DataModel.getInstance().index).get(0).toString());
            price.setText(DataModel.getInstance().arrayList2.get(DataModel.getInstance().index).get(1).toString());
            quantity.setText(DataModel.getInstance().arrayList2.get(DataModel.getInstance().index).get(2).toString());
        }


        ok = (Button) findViewById(R.id.buttonOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (DataModel.getInstance().editList == 1){
                    DataModel.getInstance().arrayList.remove(DataModel.getInstance().index);
                    DataModel.getInstance().arrayList2.remove(DataModel.getInstance().index);
                }
                list.add(name.getText().toString());
                list.add(Float.parseFloat(price.getText().toString()));
                list.add(Integer.parseInt(quantity.getText().toString()));

                DataModel.getInstance().arrayList2.add(list);
                DataModel.getInstance().arrayList.add(list.get(0).toString() + "\n" + list.get(1).toString() + " €\n" + list.get(2).toString());
                onResume();
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
