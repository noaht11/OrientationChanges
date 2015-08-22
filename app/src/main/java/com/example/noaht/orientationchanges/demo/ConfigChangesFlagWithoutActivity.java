package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;

import com.example.noaht.orientationchanges.LoggingActivity;
import com.example.noaht.orientationchanges.R;

public class ConfigChangesFlagWithoutActivity extends LoggingActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_configchanges_flag);
    }
}
