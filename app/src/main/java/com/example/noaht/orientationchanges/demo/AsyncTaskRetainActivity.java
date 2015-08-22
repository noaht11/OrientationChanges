package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noaht.orientationchanges.LoggingActivity;
import com.example.noaht.orientationchanges.R;

public class AsyncTaskRetainActivity extends AsyncTaskActivity implements AsyncTaskRetainFragment.CounterTaskListener {

    private static final String TAG_TASK_FRAGMENT = "taskFragment";

    private AsyncTaskRetainFragment mTaskFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setInfo(R.string.async_task_retain_info);

        if (savedInstanceState == null) {
            mTaskFragment = new AsyncTaskRetainFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(mTaskFragment, TAG_TASK_FRAGMENT)
                    .commit();
        } else {
            mTaskFragment = (AsyncTaskRetainFragment) getSupportFragmentManager().findFragmentByTag(TAG_TASK_FRAGMENT);
        }
    }

    @Override
    protected BaseCounterAsyncTask createTask() {
        return null;
    }

    @Override
    protected void startTask() {
        mProgressTextView.setText("");
        mTaskFragment.startTask();
    }

    @Override
    protected void cancelTask() {
        mTaskFragment.cancelTask();
    }

    @Override
    protected boolean isTaskRunning() {
        return mTaskFragment.isTaskRunning();
    }

    private void prependText(String text) {
        mProgressTextView.setText(text + "\n" + mProgressTextView.getText());
    }

    @Override
    public void onTaskProgressUpdate(int progress) {
        prependText("Progress: " + progress);
    }

    @Override
    public void onTaskFinished(boolean result) {
        prependText("Finished");
        updateButtonText(false);
    }
}
