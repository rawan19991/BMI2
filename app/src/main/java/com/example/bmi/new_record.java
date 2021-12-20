package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.UserModel;

import java.util.ArrayList;
import java.util.Calendar;

public class new_record extends AppCompatActivity {
Button savedata;
EditText weight,lenght,times;
FirebaseHelper helper;
    Calendar mcalendar=Calendar.getInstance();
    EditText mdob_et;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);
        savedata=findViewById(R.id.savedata);
        weight=findViewById(R.id.weightrecord);
        lenght=findViewById(R.id.lengthrecord);
        times=findViewById(R.id.time);
        mdob_et=findViewById(R.id.dot_et);
        mdob_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog();
            }
        });

        day=mcalendar.get(Calendar.DAY_OF_MONTH);
        year=mcalendar.get(Calendar.YEAR);
        month=mcalendar.get(Calendar.MONTH);
        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightt=weight.getText().toString();
                String lengthh=lenght.getText().toString();
                String today=mdob_et.getText().toString();
                String time=times.getText().toString();
                Intent i=new Intent(new_record.this,HomeActivity.class);
                BMI_Record_Model bmi_record_model=new BMI_Record_Model(weightt,lengthh,today);
                UserModel.userModel.bmiRecordModels.add(bmi_record_model);
                helper.AddBmiRecord(bmi_record_model);
                startActivity(i);
            }
        });
    }
    public void DateDialog(){
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                mdob_et.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }};
        DatePickerDialog dpDialog=new DatePickerDialog(this, listener, year, month, day);
        dpDialog.show();
    }
}