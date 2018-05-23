package com.example.a8672756.sambotapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

public class Lightcontrol extends AppCompatActivity {
    TextView textViewLight;
    SeekBar seekBarLight;
    CheckBox checkBoxAutomaticLight;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightcontrol);

        // Créer une instance de SensorManager
        SensorManager mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Récupérer la liste des capteurs
        List<Sensor> listeCapteurs = mySensorManager.getSensorList(Sensor.TYPE_ALL);

        // Affichage de la liste des capteurs
        TextView tv = (TextView) findViewById(R.id.textViewList);
        for (Sensor sensor : listeCapteurs) {
            tv.append("-" + sensor.getType() + "\t : \t " + sensor.getName() + "\n");
        }
    }
}
