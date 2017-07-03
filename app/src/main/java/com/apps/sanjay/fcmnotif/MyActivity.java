package com.apps.sanjay.fcmnotif;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
    private Button btnRegisterDevice;
    private EditText etEmailID;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        if(getIntent().getExtras()!=null) {
            TextView tv = (TextView) findViewById(R.id.reg_id);
            tv.setText(getIntent().getExtras().getString("title"));
        }

    }


}




