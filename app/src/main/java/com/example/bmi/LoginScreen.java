package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {
TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        getSupportActionBar().setTitle("BMI Analyzer");
        signup=findViewById(R.id.textView5);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginScreen.this,SignUpScreen.class);
                startActivity(i);

            }
        });
    }
}