package com.example.a8672756.sambotapplication;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Set;

/**
 * @author DONNET Marie
 * @author LATOUR Rodolphe
 * @author PHAM TRAN Toan
 * Class for the bluetooth connection
 * Created on may 24 2018
 */

public class ConnectionPage extends AppCompatActivity implements BluetoothCallback {

    //Variables declaration
    ToggleButton toggleBluetooth;
    ListView devices;
    Button buttonConnect;
    Button buttonMenu;
    ImageButton refresh;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_page);

        //Initiate the connection with the robot we have to change the name of the robot
        //and change the uuid
        BluetoothManager.getInstance().initializeBluetooth
                (this, "00001101-0000-1000-8000-00805F9B34FB", "RNBT-63E1");

        //Initiate the button to set the connection to the device
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

        //Initiate the button to set the list of devices
        devices = (ListView) findViewById(R.id.devices);
        devices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DataConnectionPage.getInstance().deviceChosen = i;
            }
        });

        //Initiate the button to connect the smartphone with the samrobot
        buttonConnect = (Button) findViewById(R.id.buttonConnect);
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BluetoothManager.getInstance().isBluetoothOn()) {
                    Toast.makeText(ConnectionPage.this, "The BT device is OFF!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d("BT", "==> instance = "+BluetoothManager.getInstance());
                BluetoothManager.getInstance().startDiscover(ConnectionPage.this);
            }
        });

        //Initiate the button to go to ControlPage
        buttonMenu = (Button) findViewById(R.id.buttonMainMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ConnectionPage.this
                        , ControlPage.class);
                startActivity(intent1);
            }
        });

        //Initiate the button to refresh the list of devices
        refresh = (ImageButton) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update the list of devices
                updateList();
            }
        });


        //Add devices to the Bluetooth list
        Set<BluetoothDevice> pairedDevices = BluetoothManager.getInstance().getDevices();
        for(BluetoothDevice bt : pairedDevices){
            DataConnectionPage.getInstance().arrayList.add(bt.getName());
        }
        updateList();
    }

    /**
     * on the destroy we make sure to close the connections that we made.
     */
    @Override
    protected void onDestroy() {
        BluetoothManager.getInstance().closeBluetooth(this);
        super.onDestroy();
    }

    /**
     *
     * @param returnCode
     */
    @Override
    public void onBluetoothConnection(int returnCode) {
        if(returnCode == BluetoothManager.BLUETOOTH_CONNECTED){
            Toast.makeText(ConnectionPage.this, "Connected",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ControlPage.class);

            startActivity(intent);
        }else if(returnCode == BluetoothManager.BLUETOOTH_CONNECTED_ERROR){
            Toast.makeText(ConnectionPage.this, "ConnectionError",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *
     * @param returnCode
     */
    @Override
    public void onBluetoothDiscovery(int returnCode) {

    }

    /**
     *
     * @param data
     */
    @Override
    public void onReceiveData(String data) {

    }

    /**
     * Method to update the list of devices
     */

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
