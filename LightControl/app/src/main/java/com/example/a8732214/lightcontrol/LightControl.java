package com.example.a8732214.lightcontrol;

/* Liens utiles
https://openclassrooms.com/courses/presentation-de-la-javadoc
https://mathias-seguy.developpez.com/tutoriels/android/utiliser-capteurs/
*/

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Log;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class LightControl extends AppCompatActivity{
    TextView textViewLight;
    SeekBar seekBarLight;
    CheckBox checkBoxAutomaticLight;

    //Variable to max brightness value
    private int max_light = 100;
    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;

    private SensorManager mySensorManager;
    private Sensor light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_control);

        //Instantiate seekbar, textview and checkbox objects
        final TextView textViewLight = (TextView) findViewById(R.id.textViewLight);
        CheckBox checkBoxAutomaticLight = (CheckBox) findViewById(R.id.checkBoxAutomaticLight);
        SeekBar seekBarLight = (SeekBar) findViewById(R.id.seekBarLight);

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
        SensorManager mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Obtain sensor light
        // Retur NULL if it doesn't exist
        Sensor light = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (light == null) {
            Toast.makeText(this, "Pas de capteur de luminosité", Toast.LENGTH_LONG).show();
            checkBoxAutomaticLight.setEnabled(false);
        } else {
            Toast.makeText(this, "Il y a un capteur de luminosité", Toast.LENGTH_LONG).show();
            checkBoxAutomaticLight.setEnabled(true);
        }

        if (checkBoxAutomaticLight.isChecked()){ // Automatic brightness

        }else { // Seek bar brightness
            seekBarBrightness();
        }
    }


    public void seekBarBrightness()
    {
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

            public void onStartTrackingTouch(SeekBar seekBar) {
                //Nothing handled here
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Set the minimal brightness level
                //if seek bar is 20 or any value below
                if (progress <= 20) {
                    //Set the brightness to 20
                    brightness = 20;
                } else //brightness is greater than 20
                {
                    //Set brightness variable based on the progress bar
                    brightness = progress;
                }
                //Calculate the brightness percentage
                float perc = (brightness / (float) max_light) * 100;
                //Set the brightness percentage
                textViewLight.setText((int) perc + " %");
            }
        });
    }



}

