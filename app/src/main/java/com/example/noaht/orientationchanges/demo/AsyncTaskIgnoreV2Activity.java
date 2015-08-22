package com.example.noaht.orientationchanges.demo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.noaht.orientationchanges.R;

public class AsyncTaskIgnoreV2Activity extends AsyncTaskActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setInfo(R.string.async_task_ignore_v2_info);
    }

    @Override
    protected BaseCounterAsyncTask createTask() {
        return new CounterTask();
    }

    // This type of inner class declaration for an AsyncTask is especially dangerous because even
    // though it doesn't look like it could possibly leak an Activity reference, when you instantiate
    // this class is will have an implicit reference to its parent class which is the Activity.
    private class CounterTask extends BaseCounterAsyncTask {

        private ProgressDialog mProgressDialog;

        public CounterTask() {
            mProgressDialog = new ProgressDialog(AsyncTaskIgnoreV2Activity.this);
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgress(0);
            mProgressDialog.setMessage("Task Running");
            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    cancelTask();
                }
            });
        }

        @Override
        protected void onPreExecute() {
            mProgressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mProgressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            logEvent("About to dismiss ProgressDialog");
            logEvent("If an orientation change has happened then...here comes a CRASH");
            mProgressDialog.dismiss();
            logEvent("Whew! No crash. Looks like an orientation change didn't happen");
            Toast.makeText(AsyncTaskIgnoreV2Activity.this, "Finished", Toast.LENGTH_SHORT).show();
            updateButtonText(false);
        }

        @Override
        protected void onCancelled(Boolean result) {
            super.onCancelled(result);
            updateButtonText(false);
        }
    }
}
