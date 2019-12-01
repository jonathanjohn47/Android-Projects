package com.example.progressdialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class DownloadThread extends AsyncTask<String,Integer,Float> {

    private ProgressDialog progressDialog;
    private Context mcontext;
    private Handler mHandler;

    public DownloadThread(Context context, Handler Handler) {
        mcontext = context;
        mHandler = Handler;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.e("tag", "pre" + Thread.currentThread().getName() );

        progressDialog = new ProgressDialog( mcontext );
        progressDialog.setTitle( "Bitcode" );
        progressDialog.setMessage( "Dowloading data!" );
        progressDialog.setIcon( R.mipmap.ic_launcher );
        progressDialog.setProgressStyle( ProgressDialog.STYLE_SPINNER );
        progressDialog.show();

    }

    @Override
    protected Float doInBackground(String... params) {

        Log.e("tag", "doInBg" + Thread.currentThread().getName());

        for (int j = 0; j < params.length; j++) {

            progressDialog.setMessage("Download" + params[j]);

            for (int i = 0; i <= 100; i++) {

                progressDialog.setProgress(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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

        Log.e("tag", "onPro" + Thread.currentThread().getName());

        Message message = new Message();
        message.obj = values[0];
        message.arg1 = 1;
        mHandler.sendMessage( message );

    }

    @Override
    protected void onPostExecute(Float res) {
        super.onPostExecute(res);

        Log.e("tag", "onPost" + Thread.currentThread().getName());

        progressDialog.dismiss();

        Message message = new Message();
        message.obj = res;
        message.arg2 = 2;
        mHandler.sendMessage( message );
    }
}
