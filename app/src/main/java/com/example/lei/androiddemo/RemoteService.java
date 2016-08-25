package com.example.lei.androiddemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemoteService extends Service {
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");

        return  mBinder;
    }


    private final IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub(){
        public String hello()
        {
            return "hello";
        }

    };
}
