package com.example.a8672756.sambotapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a8672756.sambotapplication.DataModel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


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
    CheckBox seekBarSpeed;
    TextView textViewSpeed;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_page);

        BluetoothManager.getInstance().initializeBluetooth(this, "000001101-0000-1000-8000-00805F9B34FB", "RNBT-6A79");
        //Start the thread responsible of receiving the data from the other device
        //BluetoothManager.getInstance().startReadingData(this);

        stop = (ImageButton) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    BluetoothManager.getInstance().sendData(ControlPage.this,"5".toString());
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
                    BluetoothManager.getInstance().sendData(ControlPage.this,"4".toString());
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
                    BluetoothManager.getInstance().sendData(ControlPage.this,"6".toString());
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
                    BluetoothManager.getInstance().sendData(ControlPage.this,"8".toString());
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
                    BluetoothManager.getInstance().sendData(ControlPage.this,"2".toString());
                    Toast.makeText(ControlPage.this, "Backward", Toast.LENGTH_SHORT).show();
                }
            }
        });

        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
        seekBarSpeed.setKeyProgressIncrement(1);
        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * Method to show the value of seek bar
             * @param seekBarLight : seek bar for speed
             * @param progress : value of seek bar
             * @param fromUser
             */
            public void onProgressChanged(SeekBar seekBarSpeed, int progress, boolean fromUser) {
                int speed = 80;
                switch (progress){
                    case 4 :
                        speed = 100;
                        if(!BluetoothManager.getInstance().isBluetoothOn()){
                            Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                        }else{
                            BluetoothManager.getInstance().sendData(ControlPage.this,"q".toString());
                            Toast.makeText(ControlPage.this, "Turn left", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3 :
                        speed = 80;
                        if(!BluetoothManager.getInstance().isBluetoothOn()){
                            Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                        }else{
                            BluetoothManager.getInstance().sendData(ControlPage.this,"t".toString());
                            Toast.makeText(ControlPage.this, "Turn left", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2 :
                        speed = 60;
                        if(!BluetoothManager.getInstance().isBluetoothOn()){
                            Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                        }else{
                            BluetoothManager.getInstance().sendData(ControlPage.this,"d".toString());
                            Toast.makeText(ControlPage.this, "Turn left", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1 :
                        speed = 40;
                        if(!BluetoothManager.getInstance().isBluetoothOn()){
                            Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                        }else{
                            BluetoothManager.getInstance().sendData(ControlPage.this,"u".toString());
                            Toast.makeText(ControlPage.this, "Turn left", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 0 :
                        speed = 20;
                        if(!BluetoothManager.getInstance().isBluetoothOn()){
                            Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                        }else{
                            BluetoothManager.getInstance().sendData(ControlPage.this,"z".toString());
                            Toast.makeText(ControlPage.this, "Turn left", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                //Set the speed of robot
                textViewSpeed.setText("Speed Robot : " + speed + " %");
            }


        //This button switch the movement mode of the robot
        switchMode = (Button) findViewById(R.id.SwitchAuto);
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!BluetoothManager.getInstance().isBluetoothOn()){
                    Toast.makeText(ControlPage.this,"The bluetooth is off", Toast.LENGTH_SHORT).show();
                }else{
                    if(switchMode.getText()  == "AUTO"){
                        BluetoothManager.getInstance().sendData(ControlPage.this,"1".toString());
                        switchMode.setText("MANUAL");
                        Toast.makeText(ControlPage.this, "Automatic mode", Toast.LENGTH_SHORT).show();
                    }else{
                        BluetoothManager.getInstance().sendData(ControlPage.this,"0".toString());
                        switchMode.setText("AUTO");
                        Toast.makeText(ControlPage.this, "Manual mode", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        dropDownMenu = (ListView) findViewById(R.id.dropDownMenu);
        //The option button leads to the connection page currently. Might be changed to dropdown a ListView
        option = (ImageButton) findViewById(R.id.options);

        /*DataModel.getInstance().arrayList.add("Connection page");
        DataModel.getInstance().arrayList.add("Developer information");
        DataModel.getInstance().arrayList.add("Light control");
        updateList_control();*/
        dropDownMenu.setVisibility(View.INVISIBLE);

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dropDownMenu.getVisibility()== View.VISIBLE) {
                    dropDownMenu.setVisibility(View.INVISIBLE);
                }else {
                    dropDownMenu.setVisibility(View.VISIBLE);
                    dropDownMenu.bringToFront();
                }
            }
        });
        dropDownMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    DataModel.getInstance().index = 0;
                    Intent intent = new Intent(ControlPage.this, ConnectionPage.class);
                    startActivity(intent);
                }

                if (i== 1){
                    DataModel.getInstance().index = 1;
                    Intent intent1 = new Intent(ControlPage.this, InfoPage.class);
                    startActivity(intent1);

                }

                if (i== 2){
                    DataModel.getInstance().index = 2;
                    Intent intent2 = new Intent(ControlPage.this, Lightcontrol.class);
                    startActivity(intent2);

                }
            }
        });


        //TODO : Check the internet connection statue
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);




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
                }else{
                    BluetoothManager.getInstance().startDiscover(ControlPage.this);
                    Toast.makeText(ControlPage.this, "Connecting...", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    protected void onResume(){
        super.onResume();
        updateList_control();
    }

    void updateList_control(){
        ArrayAdapter<String> adapter_control =
                new ArrayAdapter<String>(ControlPage.this,android.R.layout.simple_list_item_1,
                        android.R.id.text1, DataModel.getInstance().arrayList
                );
        dropDownMenu.setAdapter(adapter_control);
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

abstract class webConnection extends AsyncTask<String, Void, String>{

    String str;

    @Override
    protected String doInBackground(String... params) {
        this.str = params[0];
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        str = s;
    }

    protected String executeRequest() {
        HttpURLConnection urlConnection = null;
        String webcontent = null;
        try{
            URL url = new URL("http://.../");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            webcontent = generateString(in);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
        }
        return webcontent;
    }

    private String generateString(InputStream stream){
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        try {
            String cur;
            while ((cur = buffer.readLine()) != null){
                sb.append(cur + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
