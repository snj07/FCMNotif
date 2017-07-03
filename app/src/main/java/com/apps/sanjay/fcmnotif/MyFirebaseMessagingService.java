package com.apps.sanjay.fcmnotif;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by sanjay on 2/7/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String LOG_TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            Log.e(LOG_TAG, "Data Payload: " + remoteMessage.getData().toString());
            Map<String,String> data= remoteMessage.getData();
            String click_action = remoteMessage.getNotification().getClickAction();
            if(data!=null){
                sendPushNotification(data,click_action);
            } else{
                Log.e(LOG_TAG, "Exception: " + "error");
            }
        }
    }


    private void sendPushNotification(Map<String,String> data,String click_action) {
        String title = data.get("title");
        String message = data.get("message");
        String imageUrl = data.get("image");
        Log.d("click_action",click_action);
        MyNotificationManager mNotificationManager = new MyNotificationManager(getApplicationContext());
        Intent intent = new Intent(click_action);
        mNotificationManager.showSmallNotification(title, message, intent);
        if (imageUrl==null ||imageUrl.equals("")) {
            mNotificationManager.showSmallNotification(title, message, intent);
        } else {
            mNotificationManager.showBigNotification(title, message, imageUrl, intent);
        }

    }

}
