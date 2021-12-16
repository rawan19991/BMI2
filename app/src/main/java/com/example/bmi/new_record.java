package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.UserModel;

import java.util.ArrayList;

public class new_record extends AppCompatActivity {
Button savedata;
EditText weight,lenght,times,date;
FirebaseHelper helper;
BMI_Record_Model bmi_record_model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);
        savedata=findViewById(R.id.savedata);
        weight=findViewById(R.id.weightrecord);
        lenght=findViewById(R.id.lengthrecord);
        times=findViewById(R.id.time);
        date=findViewById(R.id.date);


        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightt=weight.getText().toString();
                String lengthh=lenght.getText().toString();
                String today=date.getText().toString();
                String time=times.getText().toString();
                Intent i=new Intent(new_record.this,HomeActivity.class);
                bmi_record_model=new BMI_Record_Model(weightt,lengthh,today);
                helper.AddBmiRecord(bmi_record_model);
                startActivity(i);
            }
        });
    }
}