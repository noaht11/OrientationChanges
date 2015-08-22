package com.example.noaht.orientationchanges.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.noaht.orientationchanges.LoggingActivity;
import com.example.noaht.orientationchanges.R;

public abstract class AsyncTaskActivity extends LoggingActivity {

    protected TextView mInfoTextView;
    protected Button mButton;
    protected TextView mProgressTextView;

    protected BaseCounterAsyncTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_async_task);

        mInfoTextView = (TextView) findViewById(R.id.info_text_view);
        mButton = (Button) findViewById(R.id.btn_task_toggle);
        mProgressTextView = (TextView) findViewById(R.id.text_view);

        mTask = createTask();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateButtonText(isTaskRunning());
    }

    protected void setInfo(int resId) {
        mInfoTextView.setText(resId);
    }

    protected void updateButtonText(boolean isTaskRunning) {
        mButton.setText(isTaskRunning ? R.string.btn_cancel_task : R.string.btn_start_task);
    }

    public void toggleTask(View view) {
        boolean isTaskRunning = isTaskRunning();
        updateButtonText(!isTaskRunning);

        if (isTaskRunning) {
            cancelTask();
        } else {
            startTask();
        }
    }

    protected void startTask() {
        mProgressTextView.setText("");
        if (mTask.getStatus() == AsyncTask.Status.FINISHED) {
            mTask = createTask();
        }
        mTask.execute(0, 100);
    }

    protected void cancelTask() {
        mTask.cancel(true);
    }

    protected boolean isTaskRunning() {
        return (mTask != null) && (mTask.getStatus() == AsyncTask.Status.RUNNING);
    }

    protected abstract BaseCounterAsyncTask createTask();
}
