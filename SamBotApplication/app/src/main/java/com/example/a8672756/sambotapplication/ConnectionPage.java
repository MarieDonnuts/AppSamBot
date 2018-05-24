package com.example.a8672756.sambotapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ConnectionPage extends AppCompatActivity implements BluetoothCallback {
    ToggleButton toggleBluetooth;
    ListView devices;
    Button buttonConnect;
    ImageButton refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_page);

        BluetoothManager.getInstance().initializeBluetooth(this, "29bb18fa-41ed-4eea-87c6-45648001da1b", "NOMDEVICE");

        toggleBluetooth = (ToggleButton) findViewById(R.id.toggleBluetooth);
        toggleBluetooth.setChecked(BluetoothManager.getInstance().isBluetoothOn());

        toggleBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                        BluetoothManager.getInstance().turnOnBluetooth(ConnectionPage.this);
                }else{
                    BluetoothManager.getInstance().turnOffBluetooth(ConnectionPage.this);
                }
            }
        });


        buttonConnect = (Button) findViewById(R.id.buttonConnect);
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BluetoothManager.getInstance().isBluetoothOn()) {
                    Toast.makeText(ConnectionPage.this, "The BT device is OFF!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                BluetoothManager.getInstance().startDiscover(ConnectionPage.this);
                Intent intent = new Intent(ConnectionPage.this, ControlPage.class);
                startActivity(intent);
            }
        });

        refresh = (ImageButton) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateList();
            }
        });

        //Add devices to the Bluetooth list

        DataConnectionPage.getInstance().arrayList.add("device1");
        updateList();

    }

    @Override
    public void onBluetoothConnection(int returnCode) {

    }

    @Override
    public void onBluetoothDiscovery(int returnCode) {

    }

    @Override
    public void onReceiveData(String data) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }

    void updateList(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ConnectionPage.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                DataConnectionPage.getInstance().arrayList
        );
        devices.setAdapter(adapter);
    }
}
