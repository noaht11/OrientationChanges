package com.example.noaht.orientationchanges.demo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.noaht.orientationchanges.LoggingFragment;
import com.example.noaht.orientationchanges.R;

public class AsyncTaskRetainFragment extends LoggingFragment {

    public interface CounterTaskListener {
        void onTaskProgressUpdate(int progress);
        void onTaskFinished(boolean result);
    }

    private CounterTaskListener mListener;
    private CounterTask mTask;

    public AsyncTaskRetainFragment() {
        mTask = new CounterTask();
    }

    public void startTask() {
        if (mTask.getStatus() == AsyncTask.Status.FINISHED) {
            mTask = new CounterTask();
        }
        mTask.execute(0, 100);
    }

    protected void cancelTask() {
        mTask.cancel(true);
    }

    protected boolean isTaskRunning() {
        return (mTask != null) && (mTask.getStatus() == AsyncTask.Status.RUNNING);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof CounterTaskListener) {
            mListener = (CounterTaskListener) activity;
        } else {
            throw new IllegalStateException("Parent Activity must implement CounterTaskListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (isTaskRunning()) {
            mTask.cancel(true);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mListener = null;
    }

    private class CounterTask extends BaseCounterAsyncTask {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (mListener != null) {
                mListener.onTaskProgressUpdate(values[0]);
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (mListener != null) {
                mListener.onTaskFinished(result);
            }
        }

    }
}
