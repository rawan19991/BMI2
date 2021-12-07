package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView next;
    private static long time_s=5000;
    private CountDownTimer counter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /* counter=new CountDownTimer(time_s,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
intent
            }
        }*/
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getSupportActionBar().hide();
        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep( time_s );

                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent i=new Intent(SplashScreen.this,LoginScreen.class);
                    startActivity(i);

                }
            }
        };thread.start();
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SplashScreen.this,LoginScreen.class);
                startActivity(i);

            }
        });

    }}

