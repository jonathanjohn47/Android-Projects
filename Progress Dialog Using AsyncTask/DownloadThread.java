package com.example.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class DownloadThread extends AsyncTask<String, Integer, Float> {

    Context mCtx;

    private ProgressDialog progressDialog;

    public DownloadThread(Context mCtx) {
        this.mCtx = mCtx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(mCtx);
        progressDialog.setTitle("Downloading...");
        progressDialog.setMessage("Your file is downloading.");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected Float doInBackground(String... strings) {

        for (int j=0; j<strings.length; j++) {
            progressDialog.setMessage(strings[j] + "");
            for (int i = 0; i <= 100; i++) {
                progressDialog.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }

                Integer[] progress = new Integer[1];
                progress[0] = i;
                publishProgress(progress);
            }
        }
        return 12.12f;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        /*
        Message message = new Message();
        message.obj = values[0];
        message.arg1 = 1;
        mHandler.sendMessage(message);

         */
    }

    @Override
    protected void onPostExecute(Float aFloat) {
        super.onPostExecute(aFloat);

        progressDialog.dismiss();
        Toast.makeText(mCtx, aFloat + "", Toast.LENGTH_SHORT).show();
        /*Message message = new Message();
        message.obj = aFloat;
        message.arg2 = 2;
        mHandler.sendMessage(message);

         */
    }
}
