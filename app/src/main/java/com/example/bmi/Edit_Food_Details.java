package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bmi.Model.Food_Model;
import com.example.bmi.Model.UserModel;

public class Edit_Food_Details extends AppCompatActivity {
EditText namefood,caloryfood;
ImageView foodimg;
Spinner cat_spinner;
Button save,uploadphoto;
public int CALORY;
FirebaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__food__details);
        foodimg = findViewById(R.id.img_food);
        namefood = findViewById(R.id.food_namee);
        caloryfood = findViewById(R.id.food_calory);
        cat_spinner = findViewById(R.id.catog_spinner);
        save = findViewById(R.id.Save);
        cat_spinner.setAdapter(new ArrayAdapter<>(Edit_Food_Details.this, android.R.layout.simple_spinner_dropdown_item, getResources()
                .getStringArray(R.array.foodCato)));
        ///////////////////////////////////////////////////////////////////////
        int img = getIntent().getIntExtra("images", 0);
        CALORY = Integer.parseInt(getIntent().getStringExtra("calos"));
        String name = getIntent().getStringExtra("foods");
        String catogries = getIntent().getStringExtra("catos");
        /////////////////////////////////////////////////////////

        foodimg.setImageResource(img);
        cat_spinner.setSelection(getIndex(cat_spinner, catogries));
        caloryfood.setText(String.format("%d", CALORY));
        namefood.setText(name);

save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String cat=cat_spinner.getSelectedItem().toString();
        String cal=caloryfood.getText().toString();
        String foodname=namefood.getText().toString();
        Food_Model food_model=new Food_Model(foodname,cal,cat);
    }
});
    }

    private int getIndex(Spinner spinner, String catogries) {
        for(int i=0;i<spinner.getCount();i++){
            if(spinner.getItemAtPosition(i).equals(catogries)){
return i ;           }
        }
        return 0;
    }


}
