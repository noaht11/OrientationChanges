package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.noaht.orientationchanges.LoggingActivity;
import com.example.noaht.orientationchanges.R;

import java.util.ArrayList;

public class RecreatingListViewActivity extends LoggingActivity {

    private static final String TAG_RECREATING_LIST_VIEW_FRAGMENT = "recreatingListViewFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recreating_list_view);

        if (savedInstanceState == null) {
            Fragment recreatingListViewFragment = new RecreatingListViewFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, recreatingListViewFragment, TAG_RECREATING_LIST_VIEW_FRAGMENT)
                    .commit();
        }
    }
}
