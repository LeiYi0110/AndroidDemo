package com.example.lei.androiddemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;

/**
 * Created by lei on 8/3/16.
 */

public class MyService extends Service {
    public class MyBinder extends Binder
    {
        public MyService getService()
        {
            return MyService.this;
        }
    }

    public MyBinder mBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void sendMessage()
    {


        Message message = Message.obtain();
        message.arg1 = 1;
        message.arg2 = 2;
        message.obj = "Demo";
        message.what = 3;
        //Bundle bundleData = new Bundle();
        //bundleData.putString("Name", "Lucy");
        //message.setData(bundleData);
        MainActivity.handler.sendMessage(message);

    }

}
