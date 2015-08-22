package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.noaht.orientationchanges.LoggingActivity;
import com.example.noaht.orientationchanges.R;

public class FragmentBackStackActivity extends LoggingActivity {

    public static final String TAG_FRAGMENT = "Fragment_%d";

    public static final String STATE_FRAGMENT_NUM = "fragmentNum";

    private int mFragmentNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_backstack);

        if (savedInstanceState == null) {
            goToNextFragment(false);
        } else {
            mFragmentNum = savedInstanceState.getInt(STATE_FRAGMENT_NUM);
        }
    }

    public void nextFragmentClick(View view) {
        goToNextFragment(true);
    }

    public void goToNextFragment(boolean addToBackStack) {
        Fragment theFragment = new FragmentBackStackFragment();
        Bundle args = new Bundle();
        args.putInt(FragmentBackStackFragment.KEY_FRAGMENT_NUM, mFragmentNum);
        theFragment.setArguments(args);

        String theTag = String.format(TAG_FRAGMENT, mFragmentNum);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, theFragment, theTag);
        if (addToBackStack) {
            transaction.addToBackStack(theTag);
        }
        transaction.commit();

        mFragmentNum++;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mFragmentNum--;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(STATE_FRAGMENT_NUM, mFragmentNum);
    }
}
