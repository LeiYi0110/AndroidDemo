package com.example.lei.androiddemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by lei on 7/27/16.
 */

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    //public Handler handler;
    @Override
    public void onReceive(Context context, Intent intent) {
        //String msg = intent.getStringExtra("msg");
        //Log.i(TAG, msg);

            Message message = Message.obtain();
            message.arg1 = 1;
            message.arg2 = 2;
            message.obj = "Demo";
            message.what = 3;
            //Bundle bundleData = new Bundle();
            //bundleData.putString("Name", "Lucy");
            //message.setData(bundleData);
            MainActivity.handler.sendMessage(message);
            //handler.sendMessage(message);

        //Toast.makeText(context,"OK",1).show();
    }
}
