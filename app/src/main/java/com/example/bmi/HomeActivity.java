package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bmi.Adapter.HomerAdapter;
import com.example.bmi.Model.BMI_Record_Model;
import com.example.bmi.Model.UserModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
TextView nomee,statues;
TextView Logout;
Button addrecord,addfood,viewfood;
public static HomerAdapter adapter;
    RecyclerView Recycl;
    FirebaseHelper helpers;
    DatabaseReference base;
    ArrayList<BMI_Record_Model> models=new ArrayList<BMI_Record_Model>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Recycl=findViewById(R.id.recyclerview_user);
        addrecord=findViewById(R.id.add_record);
        addfood=findViewById(R.id.add_food);
        viewfood=findViewById(R.id.view_food);
        nomee=findViewById(R.id.nome);
        statues=findViewById(R.id.state);
        Logout=findViewById(R.id.Logout);
base=DB.getCurrentUser();
        //////////////////////////////////////////////////////
        Recycl.setHasFixedSize(true);
        Recycl.setLayoutManager(new LinearLayoutManager(this));
        adapter=new HomerAdapter(UserModel.userModel.bmiRecordModels,HomeActivity.this);
        Recycl.setAdapter(adapter);
        nomee.setText(UserModel.userModel.getName_user());
        adapter.notifyDataSetChanged();
       /* base.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String id = DB.getCurrentUserBMIRECode().push().getKey();

                for(DataSnapshot ds:snapshot.getChildren()){
                    BMI_Record_Model bmiRecordModel=ds.child("BMIRecords").child(id).getValue(BMI_Record_Model.class);
                    UserModel.userModel.bmiRecordModels.add(bmiRecordModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/



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


}