package com.apps.sanjay.fcmnotif;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by sanjay on 2/7/17.
 */

public class VolleyServiceManager {
    private static VolleyServiceManager mVolleyService;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private VolleyServiceManager(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyServiceManager getInstance(Context context) {
        if (mVolleyService == null) {
            mVolleyService = new VolleyServiceManager(context);
        }
        return mVolleyService;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}
