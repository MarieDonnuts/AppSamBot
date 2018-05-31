package com.example.a8672756.sambotapplication;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessaging extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Log.d("Marie", "From : " + remoteMessage.getFrom());
        Log.d("Marie", "Notification Message Body : " + remoteMessage.getNotification().getBody());
    }
}
