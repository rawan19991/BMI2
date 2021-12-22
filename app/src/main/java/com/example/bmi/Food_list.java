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
    Food_Adapter adapter;
    static Food_list instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        RecyclerView rec=findViewById(R.id.recyclerview_food);
        rec.setHasFixedSize(true);
        rec.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Food_Adapter(UserModel.userModel.foodModels,this);
        rec.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public static void cheackfoodlistChange() {
        if(instance==null)return;
        instance.adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cheackfoodlistChange();
    }
}