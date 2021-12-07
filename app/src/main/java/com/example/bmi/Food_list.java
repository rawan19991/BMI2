package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bmi.Adapter.Food_Adapter;
import com.example.bmi.Adapter.HomerAdapter;
import com.example.bmi.Model.Food_Model;
import com.example.bmi.Model.UserModel;

import java.util.ArrayList;

public class Food_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        RecyclerView c=findViewById(R.id.recyclerview_food);
        c.setHasFixedSize(true);
        c.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Food_Model> list=new ArrayList<>();
        list.add(new Food_Model(R.drawable.fish,"15","fish","fish"));
        list.add(new Food_Model(R.drawable.apple,"20","apple","fruit"));
        list.add(new Food_Model(R.drawable.bread,"100","bread","carboydrates"));
        list.add(new Food_Model(R.drawable.oliveoil,"45","olive oil","fat"));
        Food_Adapter adapter=new Food_Adapter(list,this);
        c.setAdapter(adapter);


    }
}