package com.example.lei.androiddemo;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final RelativeLayout rt = (RelativeLayout)findViewById(R.id.relativeLayout);

        TextView textView = new TextView(this);
        textView.setText("OK");
        rt.addView(textView);

        /*
        LinearLayout ll = new LinearLayout(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        ll.setBackgroundColor(Color.RED);

        params.width = 200;
        params.height = 200;
        ll.setPadding(200,0,200,0);


        ll.setLayoutParams(params);

        rt.addView(ll);
        */
        View view = new View(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        params.width = 1080;
        params.height = 200;
        view.setBackgroundColor(Color.RED);


        params.setMargins(100,0,100,0);

        view.setLayoutParams(params);
        rt.addView(view);







    }
}
