package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bmi.Adapter.HomerAdapter;
import com.example.bmi.Model.UserModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
Button addrecord,addfood,viewfood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RecyclerView c=findViewById(R.id.recyclerview_user);
        addrecord=findViewById(R.id.add_record);
        addfood=findViewById(R.id.add_food);
        viewfood=findViewById(R.id.view_food);
        c.setHasFixedSize(true);
        c.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<UserModel> list=new ArrayList<>();
        list.add(new UserModel("normal","60","170","20/10/1999"));
        list.add(new UserModel("normal","60","170","20/10/1999"));
        list.add(new UserModel("normal","60","170","20/10/1999"));
        list.add(new UserModel("normal","60","170","20/10/1999"));
        list.add(new UserModel("normal","60","170","20/10/1999"));
        HomerAdapter adapter=new HomerAdapter(list,this);
        c.setAdapter(adapter);
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
    }
}