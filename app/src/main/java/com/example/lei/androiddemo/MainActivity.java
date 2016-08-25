package com.example.lei.androiddemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static Handler handler ;
    public MyService mService;



    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mService = ((MyService.MyBinder)iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService = null;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String messageInfo = msg.obj.toString();
                Toast.makeText(MainActivity.this,messageInfo,1).show();
            }
        };

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            /*
            @Override
            public void onClick(View view) {
                mService.sendMessage();
            }
            */
            @Override
            public  void onClick(View view){
                /*
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                MainActivity.this.startActivity(intent);
                */

                /*
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hyperspace_jump);
                view.startAnimation(hyperspaceJumpAnimation);
                */

                //ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);

                /*
                ObjectAnimator animX = ObjectAnimator.ofFloat(view, "x", 50f);
                ObjectAnimator animY = ObjectAnimator.ofFloat(view, "y", 100f);
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(animX, animY);
                //animSetXY.start();
                animX.start();
                */

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "OK");
                sendIntent.setType("text/plain");

                Intent chooser = Intent.createChooser(sendIntent, "box");

// Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }

            }
        });
        Thread1 t1 = new Thread1("Lei");
        Thread thread = new Thread(t1);
        Thread1 t2 = new Thread1("queenie");
        Thread thread2 = new Thread(t2);
        thread.start();
        thread2.start();

        final LinearLayout lm = (LinearLayout) findViewById(R.id.layout);

        for (int i = 0; i< 10; i++)
        {
            TextView textView = new TextView(this);
            textView.setText("Yeah");

            lm.addView(textView);
        }







        /*
        MyReceiver receiver = new MyReceiver();
        //receiver.handler = handler;

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MY_BROADCAST");

        registerReceiver(receiver, filter);

        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        intent.putExtra("msg", "hello receiver.");
        sendBroadcast(intent);
        */


        //mService.sendMessage();

        /*
        ProgressDialog dialog = new ProgressDialog(this);

        dialog.setTitle("getting data");
        dialog.setMessage("Please waite");

        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.show();
        dialog.setCancelable(false);
        */

    }


    @Override
    protected void onStart()
    {
        super.onStart();
        Intent serviceIntent = new Intent(this, MyService.class);
        bindService(serviceIntent,connection,Context.BIND_AUTO_CREATE);
        /*
        if (mService != null)
        {
            mService.sendMessage();
        }
        */
    }





}
