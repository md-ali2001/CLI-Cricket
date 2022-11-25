package com.alimasood.handcricketgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class intro extends AppCompatActivity {
    String url,matchnoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


    }

    public void playadvance(View v)
    {
        Intent s=new Intent(this,MainActivity.class);
        s.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(s);


    }

    public void playbasic(View v)
    {
         url="https://script.google.com/macros/s/AKfycbyqJW-8KZrJF421WEayaIMrZ4wpdExWP0J6J99yEvLIg60JRzHrdYCOETAONvVwSsyByg/exec";
        matchnoint="1";
        Intent i = new Intent(intro.this, MainActivity.class);
        i.putExtra("matchnoint",matchnoint);
        i.putExtra("url",url);
        startActivity(i);

    }
}