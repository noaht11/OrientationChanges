package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.noaht.orientationchanges.LoggingFragment;
import com.example.noaht.orientationchanges.R;

import java.util.ArrayList;

public class RecreatingListViewFragment extends LoggingFragment {

    private static final String STATE_LIST_ITEMS = "listItems";
    private static final String STATE_COUNTER = "counter";

    // This is declared as ArrayList, because we have to save it in the state bundle which will only
    // accept an
    private ArrayList<Item> mListItems;
    private int mCounter;

    private ListView mListView;
    private ArrayAdapter<Item> mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // This super call is not normally necessary, we're just using it here for the purposes of
        // logging
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_recreating_list_view, container, false);

        root.findViewById(R.id.btn_add_list_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                mListItems.add(new Item(mCounter));
                mAdapter.notifyDataSetChanged();
            }
        });

        mListView = (ListView) root.findViewById(R.id.list_view);

        return root;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            mListItems = (ArrayList<Item>) savedInstanceState.getSerializable(STATE_LIST_ITEMS);
            mCounter = savedInstanceState.getInt(STATE_COUNTER);
        } else {
            mListItems = new ArrayList<>();
        }

        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mListItems);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(STATE_LIST_ITEMS, mListItems);
        outState.putInt(STATE_COUNTER, mCounter);
    }
}
