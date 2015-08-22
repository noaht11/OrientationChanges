package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noaht.orientationchanges.LoggingFragment;
import com.example.noaht.orientationchanges.R;

public class FragmentReaddingEveryOnCreateFragment extends LoggingFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_readding, container, false);
    }
}
