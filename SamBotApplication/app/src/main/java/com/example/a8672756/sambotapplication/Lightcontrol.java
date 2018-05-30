package com.example.a8672756.sambotapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Log;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar.OnSeekBarChangeListener;

/**
 * Class to create the control of brightness screen
 */
public class Lightcontrol extends AppCompatActivity implements SensorEventListener{

    // Variables declaration
    TextView textViewLight;
    TextView textViewValueSensor;
    SeekBar seekBarLight;
    CheckBox checkBoxAutomaticLight;

    //SensorManager
    private SensorManager mySensorManager;
    // sensor light
    private Sensor light;
    //Variable lux
    static float lux;
    //Variable to max brightness value
    private int max_light = 255;
    //Variable to min brightness value
    private int min_light = 20;
    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;
    //button go to controlpage
    Button buttonMenuLight;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_control);

        //Instantiate seekbar, textview and checkbox objects
        textViewLight = (TextView) findViewById(R.id.textViewLight);
        checkBoxAutomaticLight = (CheckBox) findViewById(R.id.checkBoxAutomaticLight);
        seekBarLight = (SeekBar) findViewById(R.id.seekBarLight);
        textViewValueSensor = (TextView) findViewById(R.id.textViewValueSensor);


        buttonMenuLight = (Button) findViewById(R.id.buttonMenuLight);
        buttonMenuLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lightcontrol.this, ControlPage.class);
                startActivity(intent);
            }
        });


        //Get the content resolver
        cResolver = getContentResolver();
        //Get the current window
        window = getWindow();

        //Set the seekbar range between 0 and max_light
        //seek bar settings//
        //sets the range between 0 and max_light
        seekBarLight.setMax(max_light);
        //set the seek bar progress to 1
        seekBarLight.setKeyProgressIncrement(1);

        // Instentiate SensorManager
        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Obtain sensor light
        // Retur NULL if it doesn't exist
        light = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (light == null) { // if sensor light doesn't exist, toast "No brightness sensor"
            Toast.makeText(this, "Pas de capteur de luminosité", Toast.LENGTH_LONG).show();
            checkBoxAutomaticLight.setEnabled(false);
        } else { // if sensor light exists, toast "Brightness sensor"
            Toast.makeText(this, "Il y a un capteur de luminosité", Toast.LENGTH_LONG).show();
            checkBoxAutomaticLight.setEnabled(true);
        }

        // Action for click on checkbox
        checkBoxAutomaticLight.setOnClickListener(new View.OnClickListener() {
            /**
             * Method for click on checkbox
             * @param view
             */
            @Override
            public void onClick(View view) {
                if (checkBoxAutomaticLight.isChecked()) { // Automatic brightness
                    seekBarLight.setEnabled(false);
                    automaticBrightness(); // Automatic brightness
                    Toast.makeText(Lightcontrol.this, "Automatic mode", Toast.LENGTH_SHORT).show();
                } else { // Seek bar brightness
                    seekBarLight.setEnabled(true);
                    seekBarBrightness(); // Seek bar brightness
                    Toast.makeText(Lightcontrol.this, "Manual mode", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    /**
     * Method for seek bar brightness
     */
    public void seekBarBrightness()
    {
        //Light sensor on pause
        onPause();

        try {
            //Get the current system brightness
            brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
        } catch (SettingNotFoundException e) {
            //Throw an error case it couldn't be retrieved
            Log.e("Error", "Cannot access system brightness");
            e.printStackTrace();
        }

        //Set the progress of the seek bar based on the system's brightness
        seekBarLight.setProgress(brightness);

        //Register OnSeekBarChangeListener, so it can actually change values
        seekBarLight.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            /**
             * Method to change the screen brightness depending on seek bar
             * @param seekBarLight : seek bar for brightness
             */
            public void onStopTrackingTouch(SeekBar seekBarLight) {
                //Set the system brightness using the brightness variable value
                System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);
                //Get the current window attributes
                LayoutParams layoutpars = window.getAttributes();
                //Set the brightness of this window
                layoutpars.screenBrightness = brightness / (float) max_light;
                //Apply attribute changes to this window
                window.setAttributes(layoutpars);
            }

            /**
             *
             * @param seekBarLight : seek bar for brightness
             */
            public void onStartTrackingTouch(SeekBar seekBarLight) {
                //Nothing handled here
            }

            /**
             * Method to show the value of seek bar
             * @param seekBarLight : seek bar for brightness
             * @param progress : value of seek bar
             * @param fromUser
             */
            public void onProgressChanged(SeekBar seekBarLight, int progress, boolean fromUser) {
                //Set the minimal brightness level
                //if seek bar is min_light or any value below
                if (progress <= min_light) {
                    //Set the brightness to min_light
                    brightness = min_light;
                } else //brightness is greater than min_light
                {
                    //Set brightness variable based on the progress bar
                    brightness = progress;
                }
                //Calculate the brightness percentage
                float perc = (brightness / (float) max_light) * 100;
                //Set the brightness percentage
                textViewLight.setText("Light : " + (int) perc + " %");
            }
        });
    }


    /**
     * Method for seek bar brightness
     */
    public void automaticBrightness(){

        //Light sensor on resume
        onResume();

        try {
            //Get the current system brightness
            brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
        } catch (SettingNotFoundException e) {
            //Throw an error case it couldn't be retrieved
            Log.e("Error", "Cannot access system brightness");
            e.printStackTrace();
        }

        //Calculate the brightness percentage
        double perc = 0.1957*lux + 2.173;

        //Calculate the brightness
        double brightNess = (perc / 100) * max_light;
        brightness = (int) brightNess;

        // Percent is not > 100% : Correction
        if (perc > 100)
            perc = 100;


        //Set the system brightness using the brightness variable value
        System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);
        //Get the current window attributes
        LayoutParams layoutpars = window.getAttributes();
        //Set the brightness of this window
        layoutpars.screenBrightness = brightness / (float) max_light;
        //Apply attribute changes to this window
        window.setAttributes(layoutpars);


        //Set the brightness percentage
        textViewLight.setText("Light : " + (int) perc + " %");
        //Set the brightness
        textViewValueSensor.setText("Value sensor : " + Float.toString(lux));

    }

    /**
     * Sensor on pause
     */
    @Override
    protected void onPause(){
        mySensorManager.unregisterListener(this, light);
        super.onPause();
    }

    /**
     * Sensor on resume
     */
    @Override
    protected void onResume(){
        mySensorManager.registerListener(this, light,SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    /**
     * Instruction if value of brightness change (event on light sensor)
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT){
            lux = event.values[0];
            if (checkBoxAutomaticLight.isChecked())  // Automatic brightness
                automaticBrightness();
        }
    }

    /**
     * Instruction if accuracy change
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Toast.makeText(Lightcontrol.this,"onAccuracyChanged()",Toast.LENGTH_SHORT).show();
    }
}
