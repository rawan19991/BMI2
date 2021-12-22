package com.example.bmi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.Food_Model;
import com.example.bmi.Model.UserModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MoreInformation extends AppCompatActivity {
Button save_data;
EditText userWeight,userlength;
RadioGroup radioGroup;
RadioButton male,female;
FirebaseHelper helper;
     Calendar mcalendar=Calendar.getInstance();
     EditText mdob_et;
     int day,month,year;
     Button plus,min,plus1,min1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_information);
        userlength=findViewById(R.id.lengthuser);
        userWeight=findViewById(R.id.weightuser);
        mdob_et=findViewById(R.id.dob_et);
        plus=findViewById(R.id.plus);
        min=findViewById(R.id.minues);
        min1=findViewById(R.id.min);
        plus1=findViewById(R.id.plus1);

        mdob_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editplus(userWeight);
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editmin(userWeight);
            }
        });
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editplus(userlength);
            }
        });
        min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editmin(userlength);
            }
        });


        day=mcalendar.get(Calendar.DAY_OF_MONTH);
        year=mcalendar.get(Calendar.YEAR);
        month=mcalendar.get(Calendar.MONTH);
        male=findViewById(R.id.rb_male);
        female=findViewById(R.id.rb_female);
        radioGroup=findViewById(R.id.radio_group);
        int gend=radioGroup.getCheckedRadioButtonId();
        save_data=findViewById(R.id.saveedata);
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BOD=mdob_et.getText().toString();
                String gender=rb_Chosen(gend);
                String weight=userWeight.getText().toString();
                String length=userlength.getText().toString();
                UserModel.userModel.setGender(gender);
                UserModel.userModel.setDate_birth(BOD);
                helper.CompleInfromation(UserModel.userModel,MoreInformation.this);



            }
        });
    }

    public void DateDialog(){
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth)
            {
                mdob_et.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }};
        DatePickerDialog dpDialog=new DatePickerDialog(this, listener, year, month, day);
        dpDialog.show();
    }

    public String rb_Chosen(int checked_id){
        if(checked_id==female.getId()){
            return female.getText().toString();
        }
        else
            return male.getText().toString();



    }
    public  void editplus(EditText text){
        int count=Integer.parseInt(text.getText().toString());
        text.setText(count+1+"");

    }
    public  void editmin(EditText text){
        int count=Integer.parseInt(text.getText().toString());
        text.setText(count-1+"");

    }
}