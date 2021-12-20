package com.example.bmi.Model;

import com.example.bmi.R;

public class Food_Model {
    int food_img;
    String food_catogries;
    String calory;
    String food_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;


    public Food_Model(String calory, String food_name, String food_catogries) {
        this.calory = calory;
        this.food_name = food_name;
        this.food_catogries = food_catogries;
    }



    public int getFood_img() {
        if(food_catogries.equals("fish")){
            return R.drawable.fish;
        }
        else if(food_catogries.equals("fruit")){
            return R.drawable.apple;
        }
        else if(food_catogries.equals("carbohydrate")){
            return R.drawable.bread;}
            else{
            return R.drawable.oliveoil;}
    }

    public void setFood_img(int food_img) {
        this.food_img = food_img;
    }

    public String getCalory() {
        return calory;
    }

    public void setCalory(String calory) {
        this.calory = calory;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_catogries() {
        return food_catogries;
    }

    public void setFood_catogries(String food_catogries) {
        this.food_catogries = food_catogries;
    }


}
