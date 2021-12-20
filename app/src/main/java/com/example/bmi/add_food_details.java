package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.Food_Model;
import com.example.bmi.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class add_food_details extends AppCompatActivity {
Button saveFood;
EditText foodname,foodcalory;
        Spinner foodspinner;
        FirebaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_details);
         foodspinner=findViewById(R.id.catog_spinner);
        foodspinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,getResources()
                .getStringArray(R.array.foodCato)));
        saveFood=findViewById(R.id.savefood);
        foodname=findViewById(R.id.nameoffoood);
        foodcalory=findViewById(R.id.foodCalory);
        saveFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FoodN=foodname.getText().toString();
                String FoodCal=foodcalory.getText().toString();
                String foodCat=foodspinner.getSelectedItem().toString();
                Intent i=new Intent(add_food_details.this,HomeActivity.class);
                Food_Model food_model=new Food_Model(FoodN,FoodCal,foodCat);
                UserModel.userModel.foodModels.add(food_model);
                helper.AddFood(food_model);
                startActivity(i);

            }
        });





    }
}