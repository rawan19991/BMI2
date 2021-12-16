package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bmi.Adapter.HomerAdapter;
import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.UserModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
TextView name,statues;
TextView Logout;
Button addrecord,addfood,viewfood;
static HomeActivity instance;
public static HomerAdapter adapter;
    RecyclerView Recycl;
    FirebaseHelper helpers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Recycl=findViewById(R.id.recyclerview_user);
        addrecord=findViewById(R.id.add_record);
        addfood=findViewById(R.id.add_food);
        viewfood=findViewById(R.id.view_food);
        name=findViewById(R.id.name);
        statues=findViewById(R.id.state);
        Logout=findViewById(R.id.Logout);

        //////////////////////////////////////////////////////
        Recycl.setHasFixedSize(true);
        Recycl.setLayoutManager(new LinearLayoutManager(this));
        adapter=new HomerAdapter(UserModel.userModel,this);
        Recycl.setAdapter(adapter);
        cheackBmiChange();
        name.setText(UserModel.userModel.getName_user());

        addrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,new_record.class);
                finish();
                startActivity(i);
            }
        });
        addfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,add_food_details.class);
                finish();
                startActivity(i);

            }
        });
        viewfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HomeActivity.this,Food_list.class);
                finish();
                startActivity(i);

            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpers.Logout();
                Intent i=new Intent(HomeActivity.this,LoginScreen.class);
                startActivity(i);
                finish();
            }
        });
    }
    public static void cheackBmiChange() {
        if(instance==null)return;
        instance.adapter.notifyDataSetChanged();
        instance.statues.setText(UserModel.userModel.gethomeMessage);
        instance.name.setText(UserModel.userModel.getName_user());
    }

    @Override
    protected void onResume() {
        super.onResume();
        cheackBmiChange();
    }
}