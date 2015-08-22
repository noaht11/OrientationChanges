package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.noaht.orientationchanges.LoggingActivity;
import com.example.noaht.orientationchanges.R;

public class FragmentReaddingEveryOnCreateActivity extends LoggingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_readding_fragment);

        Fragment readdingFragment = new FragmentReaddingEveryOnCreateFragment();
        getSupportFragmentManager().beginTransaction()
                // Below we're using .add, which is why the Fragment will be re-added on top of itself
                // over and over again. If we use .replace, the Fragment wouldn't get re-added on top
                // of itself (so the background wouldn't get darker etc.) but we'd still be losing
                // all of its state because we're re-instantiating it every time
                .add(R.id.content_frame, readdingFragment)
                .commit();
    }
}
