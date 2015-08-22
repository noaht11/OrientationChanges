package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.noaht.orientationchanges.LoggingFragment;
import com.example.noaht.orientationchanges.R;

public class FragmentReaddingNonRecreationsFragment extends LoggingFragment {

    private static final String STATE_COUNTER = "counter";

    private TextView mCounterText;

    private int mCounter = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_not_readding, container, false);

        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(STATE_COUNTER, 0);
        }

        mCounterText = (TextView) root.findViewById(R.id.text_counter);
        mCounterText.setText(Integer.toString(mCounter));

        root.findViewById(R.id.btn_counter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                mCounterText.setText(Integer.toString(mCounter));
            }
        });

        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(STATE_COUNTER, mCounter);
    }

}
