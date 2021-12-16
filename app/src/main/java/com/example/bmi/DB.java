package com.example.bmi;

import com.example.bmi.Model.UserModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DB {
    public static DatabaseReference get_Users(){
        return FirebaseDatabase.getInstance().getReference("Users");
    }
    public static DatabaseReference getCurrentUserFood(){
        return getCurrentUser().child("Food List");

    }
    public static DatabaseReference getCurrentUserBMIRECode(){
        return getCurrentUser().child("BMI Records");

    }
    public static DatabaseReference getCurrentUserName(){
        return getCurrentUser().child("User Name");

    }
    public static DatabaseReference getCurrentUserGender(){
        return getCurrentUser().child("Gender");

    }
    public static DatabaseReference getCurrentUserBirth_date(){
        return getCurrentUser().child("Date of Birth");

    }
    public static DatabaseReference getCurrentUser(){
        return get_Users().child(UserModel.userModel.getFirebaseAuth().getCurrentUser().getUid());


    }
}
