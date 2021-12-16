package com.example.bmi.Model;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.Date;

public class UserModel {
    public static  UserModel userModel;
    public int gethomeMessage;
    FirebaseAuth firebaseAuth;
    public ArrayList<BMI_Record_Model> bmiRecordModels=new ArrayList<BMI_Record_Model>();
    public ArrayList<Food_Model> foodModels=new ArrayList<Food_Model>();
    String Name_user;
    String Email_user;
    String Password;
    String Repasssword;
    String gender;
    String date_birth;





    public UserModel( String email_user, String password) {
        Email_user = email_user;
        Password = password;
    }

    public UserModel(String name_user, String email_user, String password, String Re_password, AppCompatActivity activity ){
       this.Name_user = name_user;
        this.Email_user = email_user;
        this.Password = password;
    }



    public String getName_user() {
        return Name_user;
    }

    public void setName_user(String name_user) {
        Name_user = name_user;
    }

    public String getEmail_user() {
        return Email_user;
    }

    public void setEmail_user(String email_user) {
        Email_user = email_user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public ArrayList<BMI_Record_Model> getBmiRecordModels() {
        return bmiRecordModels;
    }

    public void setBmiRecordModels(ArrayList<BMI_Record_Model> bmiRecordModels) {
        this.bmiRecordModels = bmiRecordModels;
    }

    public ArrayList<Food_Model> getFoodModels() {
        return foodModels;
    }

    public void setFoodModels(ArrayList<Food_Model> foodModels) {
        this.foodModels = foodModels;
    }
    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }


    public void updateList(DataSnapshot snapshot, AppCompatActivity activity) {
    }
}
