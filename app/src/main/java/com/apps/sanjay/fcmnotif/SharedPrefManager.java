package com.apps.sanjay.fcmnotif;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sanjay on 2/7/17.
 */

public class SharedPrefManager {
    private static final String SHARED_PREF_KEY = "FCMNotifSharedPref";
    private static final String TOKEN_KEY = "Token_Key";

    private static SharedPrefManager msharedPreferences;
    private static Context mContext;

    private SharedPrefManager(Context context) {
        mContext = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (msharedPreferences == null) {
            msharedPreferences = new SharedPrefManager(context);
        }
        return msharedPreferences;
    }

    public void saveDeviceToken(String token) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_KEY, token);
        editor.apply();
    }

    public String getDeviceTokenString() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN_KEY, null);
    }

}
