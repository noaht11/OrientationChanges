package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.noaht.orientationchanges.LoggingFragment;
import com.example.noaht.orientationchanges.R;

public class FragmentBackStackFragment extends LoggingFragment {

    public static final String KEY_FRAGMENT_NUM = "fragmentNum";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_backstack_fragment, container, false);

        int num = getArguments().getInt(KEY_FRAGMENT_NUM);

        ((TextView) root.findViewById(R.id.text_title)).setText(getString(R.string.fragment_backstack_fragment_x, num));

        return root;
    }

}
