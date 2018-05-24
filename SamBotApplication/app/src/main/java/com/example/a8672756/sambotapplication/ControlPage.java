package com.example.a8672756.sambotapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a8672756.sambotapplication.DataModel;


public class ControlPage extends AppCompatActivity implements BluetoothCallback {
    ImageButton stop;
    ImageButton up;
    ImageButton down;
    ImageButton right;
    ImageButton left;
    ImageButton option;
    ListView dropDownMenu;
    Button switchMode;
    ImageView bluetoothStatue;
    ImageButton buttonConnectMenu;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_page);

        BluetoothManager.getInstance().initializeBluetooth(this, "29bb18fa-41ed-4eea-87c6-45648001da1b", "NOMDEVICE");
        //Start the thread responsible of receiving the data from the other device
        //BluetoothManager.getInstance().startReadingData(this);

        stop = (ImageButton) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    BluetoothManager.getInstance().sendData(ControlPage.this,"5");
                    Toast.makeText(ControlPage.this, "Stop", Toast.LENGTH_SHORT).show();
                }
            }
        });

        left = (ImageButton) findViewById(R.id.leftArrow);
        Log.d("DDD", "left="+left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    BluetoothManager.getInstance().sendData(ControlPage.this,"4");
                    Toast.makeText(ControlPage.this, "Turn left", Toast.LENGTH_SHORT).show();
                }
            }
        });

        right = (ImageButton) findViewById(R.id.rightArrow);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    BluetoothManager.getInstance().sendData(ControlPage.this,"6");
                    Toast.makeText(ControlPage.this, "Turn right", Toast.LENGTH_SHORT).show();
                }
            }
        });

        up = (ImageButton) findViewById(R.id.upArrow);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    BluetoothManager.getInstance().sendData(ControlPage.this,"8");
                    Toast.makeText(ControlPage.this, "Forward", Toast.LENGTH_SHORT).show();
                }
            }
        });

        down = (ImageButton) findViewById(R.id.downArrow);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    BluetoothManager.getInstance().sendData(ControlPage.this,"2");
                    Toast.makeText(ControlPage.this, "Backward", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //This button switch the movement mode of the robot
        switchMode = (Button) findViewById(R.id.SwitchAuto);
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    if(switchMode.getText()  == "AUTO"){
                        BluetoothManager.getInstance().sendData(ControlPage.this,"1");
                        switchMode.setText("MANUAL");
                        Toast.makeText(ControlPage.this, "Manual mode", Toast.LENGTH_SHORT).show();
                    }else{
                        BluetoothManager.getInstance().sendData(ControlPage.this,"0");
                        switchMode.setText("AUTO");
                        Toast.makeText(ControlPage.this, "Automatic mode", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dropDownMenu = (ListView) findViewById(R.id.dropDownMenu);
        //The option button leads to the connection page currently. Might be changed to dropdown a ListView
        option = (ImageButton) findViewById(R.id.options);
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataModel.getInstance().arrayList.add("test");
                UpdateList();
                /*Intent intent = new Intent(ControlPage.this, ConnectionPage.class);
                startActivity(intent);*/
            }
        });

        //Definition of the image relative to the bluetooth connection statue
        bluetoothStatue = (ImageView) findViewById(R.id.bluetoothStatue);
        if (BluetoothManager.getInstance().isBluetoothOn()){
            bluetoothStatue.setImageResource(R.drawable.bluetooth_connected);
            bluetoothStatue.setVisibility(View.VISIBLE);
        }else{
            bluetoothStatue.setImageResource(R.drawable.bluetooth_disconnected);
            bluetoothStatue.setVisibility(View.VISIBLE);
        }

        //Button used to connect and disconnect from the device
        buttonConnectMenu = (ImageButton) findViewById(R.id.buttonConnectMenu);
        buttonConnectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!BluetoothManager.getInstance().isBluetoothOn()) {
                    Toast.makeText(ControlPage.this, "The BT device is OFF!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                BluetoothManager.getInstance().startDiscover(ControlPage.this);
            }
        });



    }
    @Override
    protected void onResume(){
        super.onResume();
        UpdateList();
    }

    void UpdateList(){
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(ControlPage.this,android.R.layout.simple_list_item_1,
                        android.R.id.text1, DataModel.getInstance().arrayList
                );
        dropDownMenu.setAdapter(adapter);
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
}
