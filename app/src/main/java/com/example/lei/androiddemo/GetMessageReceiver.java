package com.example.lei.androiddemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lei on 7/27/16.
 */

public class GetMessageReceiver extends BroadcastReceiver {
    private static final String TAG = "MessageReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        //String msg = intent.getStringExtra("msg");
        //Log.i(TAG, msg);
        Toast.makeText(context,"Message",1).show();
    }
}
