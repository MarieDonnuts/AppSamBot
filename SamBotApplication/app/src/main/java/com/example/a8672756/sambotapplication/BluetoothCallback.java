package com.example.a8672756.sambotapplication;

/**
 * Created by BEPID on 5/3/16.
 * @description: function callback for the bluetooth connection
 */
public interface BluetoothCallback {

    //Callback to see how the connection between the devices has been
    abstract void onBluetoothConnection(int returnCode);
    //Callback in order to see how the Discovering is behaving
    abstract void onBluetoothDiscovery(int returnCode);
    //Callback to receive data between a BT connection
    abstract void onReceiveData(String data);
}
