package com.example.noaht.orientationchanges;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.noaht.orientationchanges.demo.AsyncTaskCancelActivity;
import com.example.noaht.orientationchanges.demo.AsyncTaskIgnoreActivity;
import com.example.noaht.orientationchanges.demo.AsyncTaskIgnoreV2Activity;
import com.example.noaht.orientationchanges.demo.AsyncTaskRetainActivity;
import com.example.noaht.orientationchanges.demo.ConfigChangesFlagWithActivity;
import com.example.noaht.orientationchanges.demo.FragmentBackStackActivity;
import com.example.noaht.orientationchanges.demo.FragmentReaddingNonRecreationsActivity;
import com.example.noaht.orientationchanges.demo.OrientationFlagActivity;
import com.example.noaht.orientationchanges.demo.FragmentReaddingEveryOnCreateActivity;
import com.example.noaht.orientationchanges.demo.RecreatingListViewActivity;
import com.example.noaht.orientationchanges.demo.ConfigChangesFlagWithoutActivity;

public class MainActivity extends LoggingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    // configChanges Flag
    public void configChangesFlagWith(View view) {
        startActivity(new Intent(this, ConfigChangesFlagWithActivity.class));
    }

    public void configChangesFlagWithout(View view) {
        startActivity(new Intent(this, ConfigChangesFlagWithoutActivity.class));
    }

    // screenOrientation Flag
    public void usingOrientationFlag(View view) {
        startActivity(new Intent(this, OrientationFlagActivity.class));
    }

    // Fragments
    public void fragmentReaddingEveryOnCreate(View view) {
        startActivity(new Intent(this, FragmentReaddingEveryOnCreateActivity.class));
    }

    public void fragmentReaddingNonRecreations(View view) {
        startActivity(new Intent(this, FragmentReaddingNonRecreationsActivity.class));
    }

    public void fragmentBackstackDemo(View view) {
        startActivity(new Intent(this, FragmentBackStackActivity.class));
    }

    // Re-creating a ListView
    public void recreatingListView(View view) {
        startActivity(new Intent(this, RecreatingListViewActivity.class));
    }

    // Handling AsyncTasks
    public void asyncTaskIgnore(View view) {
        startActivity(new Intent(this, AsyncTaskIgnoreActivity.class));
    }

    public void asyncTaskIgnoreV2(View view) {
        startActivity(new Intent(this, AsyncTaskIgnoreV2Activity.class));
    }

    public void asyncTaskCancel(View view) {
        startActivity(new Intent(this, AsyncTaskCancelActivity.class));
    }

    public void asyncTaskRetain(View view) {
        startActivity(new Intent(this, AsyncTaskRetainActivity.class));
    }
}
