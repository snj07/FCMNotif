package com.apps.sanjay.fcmnotif;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by sanjay on 2/7/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String LOG_TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(LOG_TAG, "Data Payload: " + remoteMessage.getData().toString());
        Map<String, String> data = remoteMessage.getData();
        String click_action = remoteMessage.getNotification().getClickAction();
        if (click_action == null) {
            click_action = ".MyActivity";
        }
        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
        sendPushNotification(data, title, message, click_action);


    }


    private void sendPushNotification(Map<String, String> data, String title, String message, String click_action) {
        String imageUrl = null;
        if (data != null) {
            imageUrl = data.get("image");
        }
        Log.d("click_action", click_action);
        MyNotificationManager mNotificationManager = new MyNotificationManager(getApplicationContext());
        Intent intent = new Intent(click_action);
        if (imageUrl == null || imageUrl.equals("")) {
            mNotificationManager.showSmallNotification(title, message, intent);

        } else {
            mNotificationManager.showBigNotification(title, message, imageUrl, intent);
        }

    }


}
