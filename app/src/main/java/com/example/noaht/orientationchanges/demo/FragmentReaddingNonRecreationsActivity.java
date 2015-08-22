package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.noaht.orientationchanges.LoggingActivity;
import com.example.noaht.orientationchanges.R;

public class FragmentReaddingNonRecreationsActivity extends LoggingActivity {

    private static final String TAG_READDING_FRAGMENT = "fragmentReaddingNonRecreations";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_not_readding_fragment);

        Fragment notReaddingFragment;
        if (savedInstanceState == null) {
            // This means the Activity is NOT being re-created so we have to instantiate and add
            // the Fragment ourselves
            notReaddingFragment = new FragmentReaddingNonRecreationsFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_frame, notReaddingFragment, TAG_READDING_FRAGMENT)
                    .commit();
        } else {
            // This means the Activity IS being re-created so we shouldn't instantiate ourselves
            // otherwise we'll reset the state, but we can still get a reference to the Fragment
            // like this:
            notReaddingFragment = getSupportFragmentManager().findFragmentByTag(TAG_READDING_FRAGMENT);
        }

        // This null check is just to demonstrate that the Fragment is not null
        // It should never be null so in reality this check isn't necessary for any actual code
        if (notReaddingFragment != null) {
            Toast.makeText(this, "We successfully got a reference to the Fragment either by instantiating it for the first time, or through findFragmentByTag", Toast.LENGTH_LONG).show();
        }
    }
}
