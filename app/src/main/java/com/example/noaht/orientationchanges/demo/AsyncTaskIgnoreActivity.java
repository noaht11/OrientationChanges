package com.example.noaht.orientationchanges.demo;

import android.os.Bundle;

import com.example.noaht.orientationchanges.R;

public class AsyncTaskIgnoreActivity extends AsyncTaskActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setInfo(R.string.async_task_ignore_info);
    }

    @Override
    protected BaseCounterAsyncTask createTask() {
        return new CounterTask();
    }

    // This type of inner class declaration for an AsyncTask is especially dangerous because even
    // though it doesn't look like it could possibly leak an Activity reference, when you instantiate
    // this class is will have an implicit reference to its parent class which is the Activity.
    private class CounterTask extends BaseCounterAsyncTask {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            prependText("Progress: " + values[0]);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            prependText("Finished");
            updateButtonText(false);
        }

        private void prependText(String text) {
            mProgressTextView.setText(text + "\n" + mProgressTextView.getText());
        }

    }
}
