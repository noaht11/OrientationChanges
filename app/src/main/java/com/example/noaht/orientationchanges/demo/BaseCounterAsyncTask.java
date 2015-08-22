package com.example.noaht.orientationchanges.demo;

import android.os.AsyncTask;
import android.util.Log;

/**
 * This is an {@link AsyncTask} that just counts to 100, sleeping for 50 milliseconds between each
 * number and it logs all important events.
 * This class exists because all of the AsyncTasks in this demo app do the exact same thing, except
 * for the way they display progress and the way they end- so subclasses should implement
 * onProgressUpdate and onPostExecute themselves (but they should call the super method so that we
 * get some logging).
 */
public abstract class BaseCounterAsyncTask extends AsyncTask<Integer, Integer, Boolean> {

    @Override
    protected void onPreExecute() {
        logEvent("Task Started");
    }

    @Override
    protected Boolean doInBackground(Integer... params) {
        int counter = params[0];
        while (counter <= params[1]) {
            if (isCancelled()) {
                return false;
            }

            publishProgress(counter);
            counter++;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        logEvent("Task Running: " + values[0]);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        logEvent("Task Finished");
    }

    @Override
    protected void onCancelled(Boolean result) {
        logEvent("Task Cancelled");
    }

    protected void logEvent(String event) {
        Log.d("[" + this.getClass().getSimpleName() + "]", event);
    }

}
