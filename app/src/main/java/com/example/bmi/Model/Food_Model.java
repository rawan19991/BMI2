package com.example.bmi.Model;

public class Food_Model {
    int food_img;
    String food_catogries;
    String calory;
    String food_name;


    public Food_Model(int food_img, String calory, String food_name, String food_catogries) {
        this.food_img = food_img;
        this.calory = calory;
        this.food_name = food_name;
        this.food_catogries = food_catogries;
    }



    public int getFood_img() {
        return food_img;
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
