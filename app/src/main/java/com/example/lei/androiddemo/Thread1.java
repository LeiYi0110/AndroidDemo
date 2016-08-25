package com.example.lei.androiddemo;

import android.util.Log;

/**
 * Created by lei on 8/5/16.
 */

public class Thread1 implements Runnable {

    private String name;

    public Thread1(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        /*
        int i = 0;
        while (true)
        {
            //Log.v(this.name,String.valueOf(i));
            Log.i(this.name,String.valueOf(i));
            i++;
        }
        */

        for(int i =0; i < Integer.MAX_VALUE; i++)
        {
            Log.i(this.name,String.valueOf(i));
        }
    }
}
